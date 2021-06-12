package com.foster.pet.animal.dto;

import com.foster.pet.animal.enums.BloodTypeEnum;
import com.foster.pet.animal.enums.GenderEnum;
import com.foster.pet.animal.enums.SizeEnum;
import com.foster.pet.animal.enums.TypeEnum;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ApiModel(value = "DTO para animal")
public class AnimalDTO {

	@ApiModelProperty
	private Long id;

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
	private HealthDTO health;
	
	@ApiModelProperty
	private BreedDTO breed;
}
