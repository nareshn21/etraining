package com.hcl.etraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.etraining.dto.EnrolledReponseDto;
import com.hcl.etraining.dto.MyCoursesRequestDto;
import com.hcl.etraining.dto.StudentDetailsDto;
import com.hcl.etraining.dto.StudentDto;
import com.hcl.etraining.entity.EnrolledCourse;
import com.hcl.etraining.entity.Student;
import com.hcl.etraining.repository.EnrolledRepository;
import com.hcl.etraining.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentRepository studentRepository;
	@Autowired
	EnrolledRepository enrolledRepository;
	@Override
	public StudentDetailsDto userLogin(StudentDto studentDto) {
		StudentDetailsDto studentDetailsDto = null;
		Student student = studentRepository.findByMobileNoAndPassword(studentDto.getMobileNo(),studentDto.getPassword());
		if(student!=null) {
			studentDetailsDto = new StudentDetailsDto();
			studentDetailsDto.setStudentId(student.getStudentId());
			studentDetailsDto.setStatusCode(200);
			studentDetailsDto.setMessage("Logged In Successfully..");
		}
		else {
			studentDetailsDto = new StudentDetailsDto();
			studentDetailsDto.setStatusCode(401);
			studentDetailsDto.setMessage("Enter Valid MobileNo and Password..");
		}
		return studentDetailsDto;
	}
	@Override
	public List<EnrolledReponseDto> myCourses(MyCoursesRequestDto studentCourses) throws Exception {
	
		List<EnrolledCourse> courses=enrolledRepository.findByStudentId(studentCourses.getStudentId());
		List<EnrolledReponseDto> enrolledDetailsDtos = new ArrayList<>();
		if(courses!=null) {
			for (EnrolledCourse enCourse : courses) {
				EnrolledReponseDto enrolledDetailsDto = new EnrolledReponseDto();
				BeanUtils.copyProperties(enCourse, enrolledDetailsDto);
				enrolledDetailsDtos.add(enrolledDetailsDto);
			}
		}else {
			throw new Exception("you don't have enrolled course");
		}
		return enrolledDetailsDtos;
	}

	
}
