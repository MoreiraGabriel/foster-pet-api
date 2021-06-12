package com.foster.pet.animal.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "vaccine")
@ApiModel(value = "Vacina")
public class Vaccine implements Serializable{

	private static final long serialVersionUID = -3953222806528346173L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min = 1, max = 200, message = "O campo 'Nome Vacina' deve conter entre 1 e 200 caracteres.")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "id_health")
	private Health health;
}
