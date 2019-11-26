package com.hcl.etraining.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CourseDetailsDto {

	private Long courseId;
	private String courseName;
	private String courseDuration;
}
