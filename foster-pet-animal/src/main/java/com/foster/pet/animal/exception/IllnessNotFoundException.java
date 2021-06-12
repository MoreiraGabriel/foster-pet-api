package com.foster.pet.animal.exception;

import com.foster.pet.animal.constant.ErrorCode;

public class IllnessNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 3975771801507211123L;
	
	public IllnessNotFoundException() {
		super(ErrorCode.ILLNESS_NOT_FOUND.getMessage());
	}

}
