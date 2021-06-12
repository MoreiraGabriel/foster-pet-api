package com.foster.pet.animal.enums;

public enum TypeEnum {

	CAT(1L,"Gato"),
	DOG(2L,"Cachorro");

	private Long id;
	private String description;

	TypeEnum(Long id, String description) {
		this.id = id;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}
}