package com.foster.pet.animal.request;

import java.util.List;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Api(value = "Request para criar saúde.")
public class HealthRequest {
	
	@NotNull
	@ApiModelProperty
	private Boolean isCastrated;
	
	@NotNull
	@ApiModelProperty
	private Boolean isVermifugued;
	
	@NotNull
	@ApiModelProperty
	private List<IllnessRequest> listIllness;
	
	@NotNull
	@ApiModelProperty
	private List<VaccineRequest> listVaccine;
}
