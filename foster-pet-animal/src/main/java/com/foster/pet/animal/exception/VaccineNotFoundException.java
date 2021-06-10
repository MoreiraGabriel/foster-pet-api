package com.foster.pet.animal.exception;

import com.foster.pet.animal.constant.ErrorCode;

public class VaccineNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 3975771801507211123L;
	
	public VaccineNotFoundException() {
		super(ErrorCode.VACCINE_NOT_FOUND.getMessage());
	}

}
