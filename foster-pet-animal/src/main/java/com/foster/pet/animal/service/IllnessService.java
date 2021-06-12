package com.foster.pet.animal.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.foster.pet.animal.dto.IllnessDTO;
import com.foster.pet.animal.request.IllnessRequest;

public interface IllnessService {

	IllnessDTO findById(Long id);
	
	List<IllnessDTO> findByName(String name);
	
	Page<IllnessDTO> findAll(Pageable pageable);
	
	IllnessDTO create(IllnessRequest request);
	
	IllnessDTO update(IllnessDTO request);
	
	IllnessDTO delete(Long id);
}
