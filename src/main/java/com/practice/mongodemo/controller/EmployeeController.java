package com.practice.mongodemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.mongodemo.domain.Employee;
import com.practice.mongodemo.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/all")
	public List<Employee> getAllEmployees() {

		return employeeService.getAllEmployees();
	}

	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable String id) {

		return employeeService.getEmployeeById(id);
	}

	@PostMapping(value = "/save", 
			consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee saveEmployee(@RequestBody Employee emp) {

		return employeeService.saveEmployee(emp);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteEmployeeById(@PathVariable String id) {
		
		employeeService.deleteEmployee(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping
	public ResponseEntity<HttpStatus> deleteAllEmployee(){
		
		employeeService.deleteAllEmployee();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/update/{id}")
	public Employee updateEmployee(@PathVariable("id") String empId,@RequestBody Employee newEmp) {
		return employeeService.updateEmployee(empId,newEmp);
	}
	
	@GetMapping("/company/{companyName}")
	public List<Employee> getEmployeesByCompany(@PathVariable String companyName) throws InterruptedException{
		
		Thread.sleep(2000);
		
		return employeeService.getAllEmployees();
	}

}
