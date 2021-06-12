package com.foster.pet.animal.request;

import javax.validation.constraints.NotNull;

import com.foster.pet.animal.enums.IllnessTypeEnum;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Api(value = "Request para criar doença.")
public class IllnessRequest {

	@NotNull
	@ApiModelProperty
	private String name;
	
	@NotNull
	@ApiModelProperty
	private String description;
	
	@NotNull
	@ApiModelProperty
	private IllnessTypeEnum type;
}
