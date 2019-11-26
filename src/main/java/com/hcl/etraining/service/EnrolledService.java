package com.hcl.etraining.service;

import com.hcl.etraining.dto.EnrolledReponseDto;
import com.hcl.etraining.dto.EnrolledRequestDto;

public interface EnrolledService {

	public EnrolledReponseDto enrollCourse(EnrolledRequestDto enrolledReuestDto) throws Exception;
}
