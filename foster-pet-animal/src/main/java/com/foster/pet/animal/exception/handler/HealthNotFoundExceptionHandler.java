package com.foster.pet.animal.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.foster.pet.animal.exception.HealthNotFoundException;
import com.foster.pet.animal.util.Response;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HealthNotFoundExceptionHandler extends ResponseEntityExceptionHandler{

	public final ResponseEntity<Object> exceptionHandler(HealthNotFoundException exception){
		log.error("HealthNotFoundException", exception);
		
		Response<Void> response = new Response<>();
		response.addError(exception.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}
}
