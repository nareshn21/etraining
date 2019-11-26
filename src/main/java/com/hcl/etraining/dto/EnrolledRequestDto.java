package com.hcl.etraining.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class EnrolledRequestDto {

	private Long studentId;
	private Long courseId;
}
