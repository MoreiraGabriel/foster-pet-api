package com.foster.pet.animal.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BreedDTO {

	private Long id;
	
	private String name;
	
	private String description;
}
