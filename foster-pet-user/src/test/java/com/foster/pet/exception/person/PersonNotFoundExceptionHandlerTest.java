package com.foster.pet.exception.person;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
@DisplayName("ExceptionHandler - PersonNotFound")
public class PersonNotFoundExceptionHandlerTest {

	@Autowired
	private PersonNotFoundExceptionHandler personNotFoundExceptionHandler;

	@Test
	@DisplayName("Handler to throw person not found")
	public void exceptionHandler() {
		PersonNotFoundException exception = new PersonNotFoundException();

		ResponseEntity<Object> response = this.personNotFoundExceptionHandler.exceptionHandler(exception);
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}
}
