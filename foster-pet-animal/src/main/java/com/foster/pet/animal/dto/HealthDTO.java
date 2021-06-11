package com.foster.pet.animal.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Api(value = "DTO para saúde.")
public class HealthDTO {

	@ApiModelProperty
	private Long id;
	
	@NotNull
	@ApiModelProperty
	private Boolean isCastrated;
	
	@NotNull
	@ApiModelProperty
	private Boolean isVermifugued;
	
	@NotNull
	@ApiModelProperty
	private List<IllnessDTO> listIllness;
	
	@NotNull
	@ApiModelProperty
	private List<VaccineDTO> listVaccine;
}
