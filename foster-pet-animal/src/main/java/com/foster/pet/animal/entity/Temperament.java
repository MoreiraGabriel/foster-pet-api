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
@Table(name = "temperament")
public class Temperament implements Serializable{

	private static final long serialVersionUID = -4958623214089991472L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min = 1, max = 200, message = "O campo 'Descrição' do temperamento deve conter entre 1 e 200 caracteres.")
	private String description;
	
	@OneToOne(mappedBy = "temperament")
	private Animal animal;
}
