package com.practice.mongodemo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document(collection="employee")
@JsonInclude(value = Include.NON_NULL)
public class Employee {
	
	@Id
	private String id;
	
	private String name;
	private String dept;
	private double salary;
	private String company;

}
