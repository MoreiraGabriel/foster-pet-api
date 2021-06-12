package com.foster.pet.animal.request;

import com.foster.pet.animal.enums.BloodTypeEnum;
import com.foster.pet.animal.enums.GenderEnum;
import com.foster.pet.animal.enums.SizeEnum;
import com.foster.pet.animal.enums.TypeEnum;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Api(value = "Request para animal")
public class AnimalRequest {
	
	@ApiModelProperty
	private String name;
	
	@ApiModelProperty
	private GenderEnum gender;
	
	@ApiModelProperty
	private Long age;
	
	@ApiModelProperty
	private Double weight;
	
	@ApiModelProperty
	private String color;
	
	@ApiModelProperty
	private TypeEnum animalType;
	
	@ApiModelProperty
	private BloodTypeEnum bloodType;
	
	@ApiModelProperty
	private String chip;
	
	@ApiModelProperty
	private SizeEnum size;
	
	@ApiModelProperty
	private byte[] img;
	
	@ApiModelProperty
	private String story;
	
	@ApiModelProperty
	private String sociability;
	
	@ApiModelProperty
	private String temperament;
	
	@ApiModelProperty
	private HealthRequest health;
	
	@ApiModelProperty
	private BreedRequest breed;
}
