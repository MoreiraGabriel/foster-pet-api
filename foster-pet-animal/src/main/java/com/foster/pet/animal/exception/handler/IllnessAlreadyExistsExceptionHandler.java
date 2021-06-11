package com.foster.pet.animal.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.foster.pet.animal.exception.IllnessAlreadyExistsException;
import com.foster.pet.animal.util.Response;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IllnessAlreadyExistsExceptionHandler extends ResponseEntityExceptionHandler{

	public final ResponseEntity<Object> exceptionHandler(IllnessAlreadyExistsException exception){
		log.error("IllnessAlreadyExistsException", exception);
		
		Response<Void> response = new Response<>();
		response.addError(exception.getMessage());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
}