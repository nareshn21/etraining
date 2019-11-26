package com.hcl.etraining.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.etraining.dto.EnrolledReponseDto;
import com.hcl.etraining.dto.EnrolledRequestDto;
import com.hcl.etraining.entity.Course;
import com.hcl.etraining.entity.EnrolledCourse;
import com.hcl.etraining.entity.Student;
import com.hcl.etraining.repository.CourseRepository;
import com.hcl.etraining.repository.EnrolledRepository;
import com.hcl.etraining.repository.StudentRepository;
 
@Service
public class EnrolledServiceImpl implements EnrolledService {

	@Autowired
	EnrolledRepository enrolledRepository;
	
	@Autowired 
	CourseRepository courseRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public EnrolledReponseDto enrollCourse(EnrolledRequestDto enrolledRequestDto) throws Exception {
		// TODO Auto-generated method stub
		EnrolledReponseDto enrolledResponseDto=null;
		Optional<Course> course=courseRepository.findById(enrolledRequestDto.getCourseId());
		Optional<Student> student=studentRepository.findById(enrolledRequestDto.getStudentId());
		if(!course.isPresent()) {
			
			throw new Exception("Course is not available");
		
		}else if(!student.isPresent()) {
			throw new Exception("student is not present");
		}
		else {
			Optional<EnrolledCourse> courses=enrolledRepository.findByStudentIdAndCourseId(enrolledRequestDto.getStudentId(),enrolledRequestDto.getCourseId());
			//Optional<EnrolledCourse> courses=enrolledRepository.findByStudentIdAndCourseId(201L,101L);

			
			if(courses.isPresent()) {
				
				throw new Exception("course already enrolled");
			}else {
				enrolledResponseDto=new EnrolledReponseDto();
				EnrolledCourse enrolledCourse=new EnrolledCourse();
				enrolledCourse.setCourseId(enrolledRequestDto.getCourseId());
				enrolledCourse.setCourseName(course.get().getCourseName());
				enrolledCourse.setCourseDuration(course.get().getCourseDuration());
				enrolledCourse.setStudentId(student.get().getStudentId());
				enrolledCourse.setStartDate(LocalDate.now());		
				enrolledRepository.save(enrolledCourse);
				BeanUtils.copyProperties(enrolledCourse, enrolledResponseDto);
			}

		}
		return enrolledResponseDto;
			}
	
}
