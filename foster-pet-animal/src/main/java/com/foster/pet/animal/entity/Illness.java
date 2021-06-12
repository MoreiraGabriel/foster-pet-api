package com.foster.pet.animal.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.foster.pet.animal.enums.IllnessTypeEnum;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "illness")
public class Illness implements Serializable{

	private static final long serialVersionUID = 7738512069221873973L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min = 1, max = 200, message = "O campo 'Nome' de Enfermidade deve conter entre 1 e 200 caracteres.")
	private String name;
	
	@Size(min = 1, max = 200, message = "O campo 'Descrição' do Enfermidade deve conter entre 1 e 200 caracteres.")
	private String description;
	
	@Enumerated(EnumType.STRING)
	private IllnessTypeEnum type;
	
	@ManyToOne
	@JoinColumn(name = "id_health")
	private Health health;
	
}
