package com.foster.pet.animal.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.foster.pet.animal.dto.VaccineDTO;
import com.foster.pet.animal.request.VaccineRequest;

public interface VaccineService {

	VaccineDTO findById(Long id);
	
	List<VaccineDTO> findByName(String name);
	
	Page<VaccineDTO> findAll(Pageable pageable);
	
	VaccineDTO create(VaccineRequest request);
	
	VaccineDTO update(Long id, VaccineRequest request);
	
	VaccineDTO delete(Long id);
}
