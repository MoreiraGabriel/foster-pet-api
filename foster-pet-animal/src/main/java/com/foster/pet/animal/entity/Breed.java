package com.foster.pet.animal.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "breed")
public class Breed implements Serializable{

	private static final long serialVersionUID = -4373685162200116685L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min = 1, max = 200, message = "O campo 'Nome' de Raça deve conter entre 1 e 200 caracteres.")
	private String name;
	
	@Size(min = 1, max = 200, message = "O campo 'Descrição' da Raça deve conter entre 1 e 200 caracteres.")
	private String description;
	
	@OneToOne(mappedBy = "breed")
	private Animal animal;
}
