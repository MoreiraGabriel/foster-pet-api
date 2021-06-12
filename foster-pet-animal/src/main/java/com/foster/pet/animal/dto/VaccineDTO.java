package com.foster.pet.animal.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Api(value = "DTO para vacina")
public class VaccineDTO {
	
	@ApiModelProperty(value = "id")
	private Long id;
	
	@ApiModelProperty("Nome da vacina")
	private String name;

}
