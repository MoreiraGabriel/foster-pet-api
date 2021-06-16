package com.foster.pet.animal.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.foster.pet.animal.dto.AnimalDTO;
import com.foster.pet.animal.request.AnimalRequest;

public interface AnimalService {

	Page<AnimalDTO> findAll(Pageable pageable);
	
	AnimalDTO findById(Long id);
	
	List<AnimalDTO> findByName(String name);
	
	List<AnimalDTO> findByAnimalType(String type);
	
	AnimalDTO create(AnimalRequest request);
	
	AnimalDTO update(AnimalDTO request);
	
	AnimalDTO delete(Long id);
}
