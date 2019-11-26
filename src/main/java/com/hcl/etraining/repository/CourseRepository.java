package com.hcl.etraining.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.etraining.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{
	List<Course> findByCourseNameStartsWith(String courseName);
	


}
