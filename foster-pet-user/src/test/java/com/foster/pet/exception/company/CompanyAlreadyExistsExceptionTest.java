package com.foster.pet.exception.company;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.foster.pet.constant.ErrorCode;

@SpringBootTest
@ActiveProfiles("test")
@DisplayName("Exception - CompanyAlreadyExists")
public class CompanyAlreadyExistsExceptionTest {

	@Test
	@DisplayName("Throw company already exists")
	public void companyAlreadyExistsExceptionTest() {
		CompanyAlreadyExistsException exception = new CompanyAlreadyExistsException();
		assertEquals(exception.getMessage(), ErrorCode.COMPANY_ALREADY_EXISTS.getMessage());
	}

	@Test
	@DisplayName("Throw company already exists with message")
	public void companyAlreadyExistsExceptionTestWithMessage() {
		CompanyAlreadyExistsException exception = new CompanyAlreadyExistsException(
				ErrorCode.COMPANY_ALREADY_EXISTS.getMessage());
		assertEquals(exception.getMessage(), ErrorCode.COMPANY_ALREADY_EXISTS.getMessage());
	}

	@Test
	@DisplayName("Throw company already exists with error code")
	public void companyAlreadyExistsExceptionTestWithErrorCode() {
		CompanyAlreadyExistsException exception = new CompanyAlreadyExistsException(ErrorCode.COMPANY_ALREADY_EXISTS);
		assertEquals(exception.getMessage(), ErrorCode.COMPANY_ALREADY_EXISTS.getMessage());
	}
}
