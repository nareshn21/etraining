package com.hcl.etraining.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.etraining.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
public	 Student findByMobileNoAndPassword(Long integer, String password);

}
