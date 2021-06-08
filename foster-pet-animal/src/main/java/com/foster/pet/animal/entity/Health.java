package com.foster.pet.animal.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "health")
public class Health implements Serializable{

	private static final long serialVersionUID = 7495171530712611924L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Boolean isCastrated;
	
	private Boolean isVermifugued;
	
	private Illness illness;
	
	private Vaccine vaccine;
	
	@OneToOne(mappedBy = "health")
	private Animal animal;
}
