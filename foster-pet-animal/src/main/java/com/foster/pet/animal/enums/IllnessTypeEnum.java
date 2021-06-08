package com.foster.pet.animal.enums;

public enum IllnessTypeEnum {
	
	CONGENITAL("CONGENITO"), DEFICIENCY("DEFICIÊNCIA");
	
	private String description;

	private IllnessTypeEnum(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
