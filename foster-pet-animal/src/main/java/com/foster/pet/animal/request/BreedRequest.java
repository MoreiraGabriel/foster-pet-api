package com.foster.pet.animal.request;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BreedRequest {

	@NotNull
	private String name;
	
	@NotNull
	private String description;
}
