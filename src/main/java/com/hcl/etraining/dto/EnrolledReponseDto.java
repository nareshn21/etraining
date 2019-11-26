package com.hcl.etraining.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EnrolledReponseDto {

	 
	 private Long courseId;
	 private String courseName;
	 private String CourseDuration;
	 private LocalDate startDate;
}
