package com.foster.pet.animal.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.foster.pet.animal.enums.BloodTypeEnum;
import com.foster.pet.animal.enums.GenderEnum;
import com.foster.pet.animal.enums.SizeEnum;
import com.foster.pet.animal.enums.TypeEnum;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Table(name = "animal")
@Entity
public class Animal implements Serializable{

	private static final long serialVersionUID = 7480195581609667872L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	@Size(min = 1, max = 200, message = "O campo 'Nome' do animal deve conter entre 1 e 200 caracteres.")
	private String name;
	
	@Enumerated(EnumType.STRING)
	private GenderEnum gender;
	
	@Size(min = 0, max = 30, message = "O campo idade deve ir de 0 até 30 anos.")
	private Long age;
	
	@Size(min = 0, max = 200, message = "O campo 'Peso' deve ir até 200.")
	private Double weight;
	
	private String color;
	
	@Enumerated(EnumType.STRING)
	private TypeEnum animalType;
	
	@Enumerated(EnumType.STRING)
	private BloodTypeEnum bloodType;
	
	@Column(nullable = true)
	private String chip;
	
	@Enumerated(EnumType.STRING)
	private SizeEnum size;
	
	@Lob
	private byte[] img;
	
	@Size(min = 1, max = 250, message = "O campo 'História' deve conter entre 1 e 250 caracteres.")
	private String story;
	
	@Size(min = 1, max = 200, message = "O campo 'Descrição' de sociabilidade deve conter entre 1 e 200 caracteres.")
	private String sociability;
	
	@NotNull
	@Column(nullable = true)
	private String temperament;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_health")
	private Health health;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_breed")
	private Breed breed;
}
