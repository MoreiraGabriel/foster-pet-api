package com.foster.pet.animal.exception;

import com.foster.pet.animal.constant.ErrorCode;

public class VaccineAlreadyExistsException extends RuntimeException{

	private static final long serialVersionUID = 3975771801507211123L;
	
	public VaccineAlreadyExistsException() {
		super(ErrorCode.BREED_ALREADY_EXISTS.getMessage());
	}

}
