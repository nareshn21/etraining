package com.hcl.etraining.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDetailsDto {
	
	private Long studentId;
	private String message;
	private Integer statusCode;

}
