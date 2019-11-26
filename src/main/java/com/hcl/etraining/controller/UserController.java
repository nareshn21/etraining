package com.hcl.etraining.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.etraining.dto.EnrolledReponseDto;
import com.hcl.etraining.dto.MyCoursesRequestDto;
import com.hcl.etraining.dto.StudentDetailsDto;
import com.hcl.etraining.dto.StudentDto;
import com.hcl.etraining.service.StudentService;

@RestController
public class UserController {
@Autowired
StudentService studentService;

	@PostMapping("/login")
	public ResponseEntity<StudentDetailsDto> userLogin(StudentDto studentDto){
		StudentDetailsDto studentDetailsDto = studentService.userLogin(studentDto);
		 return new ResponseEntity<>(studentDetailsDto, HttpStatus.OK);
	}
	@GetMapping("/mycourses")
	public ResponseEntity <List<EnrolledReponseDto>> myCourses(MyCoursesRequestDto studentCourses) throws Exception {
		List<EnrolledReponseDto> enrolledResponseDto=studentService.myCourses(studentCourses);
		 return new ResponseEntity<>(enrolledResponseDto, HttpStatus.OK);
	}
}
