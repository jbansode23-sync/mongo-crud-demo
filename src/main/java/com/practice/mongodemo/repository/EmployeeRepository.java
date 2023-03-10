package com.practice.mongodemo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.practice.mongodemo.domain.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String>{
	
	

}
