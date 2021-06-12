package com.foster.pet.animal.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.foster.pet.animal.dto.HealthDTO;
import com.foster.pet.animal.request.HealthRequest;

public interface HealthService {

	Page<HealthDTO> findAll(Pageable pageable);
	
	HealthDTO findById(Long id);
	
	List<HealthDTO> findByAnimal_Name(String name);
	
	HealthDTO create(HealthRequest request);
	
	HealthDTO update(HealthDTO request);
	
	HealthDTO delete(Long id);
}
