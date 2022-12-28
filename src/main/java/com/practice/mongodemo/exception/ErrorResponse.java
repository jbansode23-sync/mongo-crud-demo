package com.practice.mongodemo.exception;

import lombok.Data;

@Data
public class ErrorResponse {

	private int code;
	private String description;
}
