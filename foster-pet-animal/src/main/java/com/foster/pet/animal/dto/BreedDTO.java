package com.foster.pet.animal.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Api(value = "DTO para raça")
public class BreedDTO {

	@ApiModelProperty(value = "id")
	private Long id;
	
	@ApiModelProperty(value = "Nome")
	private String name;
	
	@ApiModelProperty(value = "Descrição")
	private String description;
}
