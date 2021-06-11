package com.foster.pet.animal.exception;

import com.foster.pet.animal.constant.ErrorCode;

public class IllnessAlreadyExistsException extends RuntimeException{

	private static final long serialVersionUID = 3975771801507211123L;
	
	public IllnessAlreadyExistsException() {
		super(ErrorCode.ILLNESS_ALREADY_EXISTS.getMessage());
	}

}
