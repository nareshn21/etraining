package com.hcl.etraining.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.etraining.dto.CourseDetailsDto;
import com.hcl.etraining.dto.CourseDto;
import com.hcl.etraining.entity.Course;
import com.hcl.etraining.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {
@Autowired
CourseRepository courseRepository;
	
@Override
	public List<CourseDetailsDto> courses() {
		List<Course> courses = courseRepository.findAll();
		List<CourseDetailsDto> courseDetailsDtos = new ArrayList<>();
		for (Course course : courses) {
			CourseDetailsDto courseDetailsDto = new CourseDetailsDto();
			BeanUtils.copyProperties(course, courseDetailsDto);
			courseDetailsDtos.add(courseDetailsDto);
		}

		return courseDetailsDtos;
	}

	@Override
	public CourseDetailsDto searchCourseById(Long courseId) throws Exception {
		CourseDetailsDto courseDetailsDto= null;
		
		Optional<Course> courseNameByid=courseRepository.findById(courseId);
		if(courseNameByid.isPresent()) {
			courseDetailsDto=new CourseDetailsDto();
			BeanUtils.copyProperties(courseNameByid.get(), courseDetailsDto);
			return courseDetailsDto;
		}
		else {
			throw new Exception("Course unavailable");
		}
	}

	@Override
	public List<CourseDetailsDto> serachCourseByName(CourseDto courseDto) throws Exception {
		
		List<Course> courses=courseRepository.findByCourseNameStartsWith(courseDto.getCourseName());
		List<CourseDetailsDto> courseDetailsDtos = new ArrayList<>();
		for(Course course: courses) {
			
			CourseDetailsDto courseDetailsDtos1=new CourseDetailsDto();
			BeanUtils.copyProperties(course, courseDetailsDtos1);
			courseDetailsDtos.add(courseDetailsDtos1);
			
			
			
		}
		
		return courseDetailsDtos;
	}
}
