package com.hcl.etraining.service;

import java.util.List;

import com.hcl.etraining.dto.CourseDetailsDto;
import com.hcl.etraining.dto.CourseDto;

public interface CourseService {

	List<CourseDetailsDto> courses();
	public CourseDetailsDto searchCourseById(Long courseId) throws Exception;
	public List<CourseDetailsDto> serachCourseByName(CourseDto courseDto) throws Exception;
}
