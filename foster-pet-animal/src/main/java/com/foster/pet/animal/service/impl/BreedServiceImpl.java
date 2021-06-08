package com.foster.pet.animal.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.foster.pet.animal.dto.BreedDTO;
import com.foster.pet.animal.request.BreedRequest;
import com.foster.pet.animal.service.BreedService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BreedServiceImpl implements BreedService {

	@Override
	public Page<BreedDTO> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BreedDTO findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BreedDTO findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BreedDTO create(BreedRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BreedDTO update(BreedRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
