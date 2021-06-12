package com.foster.pet.animal.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	@OneToMany(mappedBy = "health",
			cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Illness> listIllness;
	
	@OneToMany(mappedBy = "health",
			cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Vaccine> listVaccine;
	
	@OneToOne(mappedBy = "health")
	private Animal animal;
}
