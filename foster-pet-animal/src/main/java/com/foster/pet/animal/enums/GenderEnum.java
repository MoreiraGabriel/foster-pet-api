package com.foster.pet.animal.enums;

public enum GenderEnum {
	MALE("Macho"), FEMALE("Fêmea");
	
	private String description;

	private GenderEnum(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
