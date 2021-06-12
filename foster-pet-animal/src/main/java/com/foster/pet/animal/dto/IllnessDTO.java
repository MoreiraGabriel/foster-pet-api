package com.foster.pet.animal.dto;

import com.foster.pet.animal.enums.IllnessTypeEnum;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Api("Dto para doença")
public class IllnessDTO {

	@ApiModelProperty(value = "id")
	private Long id;
	
	@ApiModelProperty(value = "Nome")
	private String name;
	
	@ApiModelProperty(value = "Descrição")
	private String description;
	
	@ApiModelProperty(value = "Tipo CONGENITO ou DEFICIÊNCIA")
	private IllnessTypeEnum type;
}
