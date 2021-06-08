package com.foster.pet.animal.enums;

public enum BloodTypeEnum {

	TIPOA("Tipo A", "Gato"),
	TIPOB("Tipo B", "Gato"),
	TIPOAB("Tipo AB", "Gato"),
	DEA11("DEA 1.1", "Cahorro"),
	DEA12("DEA 1.2", "Cahorro"),
	DEA13("DEA 1.3", "Cahorro"),
	DEA3("DEA 3", "Cahorro"),
	DEA4("DEA 4", "Cahorro"),
	DEA5("DEA 5", "Cahorro"),
	DEA7("DEA 3", "Cahorro");
	
	private String description;
	private String animal;
	
	private BloodTypeEnum(String description, String animal) {
		this.description = description;
		this.animal = animal;
	}

	public String getDescription() {
		return description;
	}

	public String getAnimal() {
		return animal;
	}
	
}
