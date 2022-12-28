package com.practice.mongodemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.practice.mongodemo.domain.Employee;
import com.practice.mongodemo.exception.EmployeeNotFoundException;
import com.practice.mongodemo.repository.EmployeeRepository;

@Component
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	@Override
	public List<Employee> getAllEmployees() {
		return repository.findAll();
	}

	@Override
	public Employee getEmployeeById(String id) {
		
		Optional<Employee> emp = repository.findById(id);
		if (emp.isPresent()) {
			return emp.get();
		}
		throw new EmployeeNotFoundException("Employee not found with id : " + id);
	}

	@Override
	public Employee saveEmployee(Employee emp) {
		return repository.save(emp);
	}

	@Override
	public void deleteEmployee(String id) {
		
		//check employee exists
		getEmployeeById(id);
		
		repository.deleteById(id);
	}

	@Override
	public Employee updateEmployee(String empId,Employee newEmp) {
		Employee oldEmp = getEmployeeById(empId);
		
		oldEmp.setSalary(newEmp.getSalary());
		oldEmp.setDept(newEmp.getDept());
		oldEmp.setName(newEmp.getName());
		return repository.save(oldEmp);
	}

	@Override
	public void deleteAllEmployee() {
		
		repository.deleteAll();
		
	}

}
