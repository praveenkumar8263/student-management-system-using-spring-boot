package com.student_boot_project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.student_boot_project.config.ResponseStructure;

@RestController
public class ApplicationHandler {

	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> studentNotFoundById(StudentNotFoundException exception) {

		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage(exception.getMessage());
		responseStructure.setData("Student Object with given ID is not present...!!!!");
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);

	}
}
