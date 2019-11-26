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

@Entity
@Table(name="student_info")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	/*
	 * @OneToMany(mappedBy="student") Set<EnrolledCourse> enrolledCourse;
	 */
	private Long studentId;
	
	
	private String studentName;
	private String password;
	private Long mobileNo;
	
	


}
