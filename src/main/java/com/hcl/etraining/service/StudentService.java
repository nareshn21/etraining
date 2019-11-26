package com.hcl.etraining.service;

import java.util.List;

import com.hcl.etraining.dto.EnrolledReponseDto;
import com.hcl.etraining.dto.MyCoursesRequestDto;
import com.hcl.etraining.dto.StudentDetailsDto;
import com.hcl.etraining.dto.StudentDto;


public interface StudentService {

	public StudentDetailsDto userLogin(StudentDto studentDto);
	public List<EnrolledReponseDto> myCourses(MyCoursesRequestDto studentCourses) throws Exception;
}
