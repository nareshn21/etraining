package com.hcl.etraining.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.etraining.entity.EnrolledCourse;

@Repository
public interface EnrolledRepository extends JpaRepository<EnrolledCourse, Long> {

	Optional<EnrolledCourse> findByStudentIdAndCourseId(Long studentId, Long courseId);
	List<EnrolledCourse> findByStudentId(Long studentId);
}
