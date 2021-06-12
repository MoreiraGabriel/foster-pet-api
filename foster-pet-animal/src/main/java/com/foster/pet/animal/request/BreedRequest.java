package com.foster.pet.animal.request;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Api(value = "Request para criar raça.")
public class BreedRequest {
	
	@NotNull
	@ApiModelProperty
	private String name;
	
	@NotNull
	@ApiModelProperty
	private String description;
}
