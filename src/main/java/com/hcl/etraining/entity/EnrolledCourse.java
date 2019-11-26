package com.hcl.etraining.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Enrolled_Course_Details")
public class EnrolledCourse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long  enrolledCoursesId;
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="student_id") Student student;
	 * 
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="course_id") Course course;
	 */
	private Long studentId;
	private Long courseId;
	private String courseName;
	private String courseDuration;
	private LocalDate startDate;
}
