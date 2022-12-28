package com.practice.mongodemo.service;

import java.util.List;

import com.practice.mongodemo.domain.Employee;

public interface EmployeeService {
	
	List<Employee> getAllEmployees();
	
	Employee getEmployeeById(String id);
	
	Employee saveEmployee(Employee emp);
	
	void deleteEmployee(String id);

	Employee updateEmployee(String empId, Employee newEmp);

	void deleteAllEmployee();

}
