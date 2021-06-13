package com.foster.pet.animal.request;

import java.io.Serializable;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Api(value = "Request para vacina")
public class VaccineRequest implements Serializable{

	private static final long serialVersionUID = 7122070624246133286L;
	
	@ApiModelProperty("Nome da vacina")
	private String name;

}
