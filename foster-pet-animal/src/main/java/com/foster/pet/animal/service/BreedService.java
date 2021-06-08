package com.foster.pet.animal.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.foster.pet.animal.dto.BreedDTO;
import com.foster.pet.animal.request.BreedRequest;

public interface BreedService {

	Page<BreedDTO> findAll(Pageable pageable);
	
	BreedDTO findById(Long id);
	
	BreedDTO findByName(String name);
	
	BreedDTO create(BreedRequest request);
	
	BreedDTO update(BreedRequest request);
	
	Boolean delete(Long id);
}
