package com.hcl.etraining.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.etraining.dto.CourseDetailsDto;
import com.hcl.etraining.dto.CourseDto;
import com.hcl.etraining.dto.EnrolledReponseDto;
import com.hcl.etraining.dto.EnrolledRequestDto;
import com.hcl.etraining.service.CourseService;
import com.hcl.etraining.service.EnrolledService;

@RestController
@RequestMapping("/courses")
public class CourseController {
	
	@Autowired
	CourseService courseService;
	@Autowired
	EnrolledService enrolledService;
	@GetMapping("")
	
	ResponseEntity<List<CourseDetailsDto>> getAllCourses(){
		
		List<CourseDetailsDto> courseDetailsDtos = courseService.courses();
		return new ResponseEntity<>(courseDetailsDtos, HttpStatus.OK);
	}
	@GetMapping("course/{courseId}")
	ResponseEntity<CourseDetailsDto> searchCourseById(@PathVariable Long courseId) throws Exception{
		
		CourseDetailsDto courseDetailsDto=courseService.searchCourseById(courseId);
		return new ResponseEntity<>(courseDetailsDto, HttpStatus.OK);
	}
	@GetMapping("courseByname")
	ResponseEntity <List<CourseDetailsDto>> searchByName(CourseDto courseDto) throws Exception{
		
		List<CourseDetailsDto> courseDetailsDto=courseService.serachCourseByName(courseDto);
		return new ResponseEntity<>(courseDetailsDto, HttpStatus.OK);
	}
	@PostMapping("EnrolledCourse")
	ResponseEntity<EnrolledReponseDto> enrollCourse(EnrolledRequestDto enrolledRequestDto) throws Exception{
		
		EnrolledReponseDto enrolledResponseDto=enrolledService.enrollCourse(enrolledRequestDto);
		return new ResponseEntity<>(enrolledResponseDto,HttpStatus.OK);
	}

}
