package com.hcl.etraining.entity;

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
@Table(name="course_info")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/*
	 * @OneToMany(mappedBy="course") Set<EnrolledCourse> enrolledCourse;
	 */
	private Long courseId;
	
	private String courseName;
	private String courseDuration;
}
