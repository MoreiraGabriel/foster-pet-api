package com.foster.pet.animal.exception;

import com.foster.pet.animal.constant.ErrorCode;

public class BreedNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 3975771801507211123L;
	
	public BreedNotFoundException() {
		super(ErrorCode.BREED_NOT_FOUND.getMessage());
	}

}
