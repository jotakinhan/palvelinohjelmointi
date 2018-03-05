package com.example.demo.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student2, Long> {
	
	List<Student2> findAll();

}
