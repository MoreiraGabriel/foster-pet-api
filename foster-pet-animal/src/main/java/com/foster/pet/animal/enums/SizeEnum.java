package com.foster.pet.animal.enums;

public enum SizeEnum {
	
	LITTLE("Pequeno"),
	AVERAGE("Médio"),
	BIG("Grande");
	
	private String description;

	private SizeEnum(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
	
}