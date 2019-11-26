package com.hcl.etraining.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.etraining.repository.EnrolledRepository;
import com.hcl.etraining.repository.StudentRepository;

@RunWith(MockitoJUnitRunner.class)
public class StudentServiceImplTest {

	@InjectMocks
	StudentServiceImpl studentServiceImpl;
	@Mock
	StudentRepository studentRepository;

	/*
	 * @Mock EnrolledRepository enrolledRepository;
	 */
	@Test
	public void testUserLogin() {
		
		
		
	}
}
