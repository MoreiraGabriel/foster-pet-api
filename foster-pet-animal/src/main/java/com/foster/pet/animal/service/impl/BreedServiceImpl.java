package com.foster.pet.animal.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.foster.pet.animal.dto.BreedDTO;
import com.foster.pet.animal.entity.Breed;
import com.foster.pet.animal.repository.BreedRepository;
import com.foster.pet.animal.request.BreedRequest;
import com.foster.pet.animal.service.BreedService;
import com.foster.pet.animal.service.processor.BreedProcessor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BreedServiceImpl implements BreedService {
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private BreedRepository breedRepository;
	
	@Autowired
	private BreedProcessor breedProcessor;

	@Override
	public Page<BreedDTO> findAll(Pageable pageable) {
		log.info("Start - BreedServiceImpl.findAll - Pageable:{}", pageable);
		
		Page<Breed> breeds = breedRepository.findAll(pageable);
		Page<BreedDTO> dtos = breeds.map(breed -> mapper.map(breed, BreedDTO.class));
		
		log.info("End - BreedServiceImpl.findAll - Page<BreedDTO>:{}", dtos.toString());
		
		return dtos;
	}

	@Override
	public BreedDTO findById(Long id) {
		log.info("Start - BreedServiceImpl.findById - Id:{}", id);
		Breed breed = breedProcessor.exists(id);
		BreedDTO dto = mapper.map(breed, BreedDTO.class);
		log.info("End -BreedServiceImpl.findById - Id:{}", id);
		return dto;
	}

	@Override
	public List<BreedDTO> findByName(String name) {
		log.info("Start - BreedServiceImpl.findByName - Name:{}", name);
		List<Breed> listBreed = breedProcessor.exists(name);
		List<BreedDTO> listDto = mapper.map(listBreed, new TypeToken<List<BreedDTO>>() {}.getType());
		
		log.info("End - BreedServiceImpl.findByName - Name:{}", name);
		return listDto;
	}

	@Override
	public BreedDTO create(BreedRequest request) {
		log.info("Start - BreedServiceImpl.create - BreedRequest:{}");
		
		breedProcessor.alreadyExists(request.getName());
		
		Breed breed = mapper.map(request, Breed.class);
		breed = breedRepository.save(breed);
		
		BreedDTO dto = mapper.map(breed, BreedDTO.class);
		
		log.info("End - BreedServiceImpl.create - BreedRequest:{}");
		return dto;
	}

	@Override
	public BreedDTO update(Long id, BreedRequest request) {
		log.info("Start - BreedServiceImpl.update - BreedRequest:{}", BreedRequest.class);
		
		Breed breed =  breedProcessor.exists(id);
		breed.setName(request.getName());
		breed.setDescription(request.getDescription());
		
		breed = breedRepository.save(breed);
		
		BreedDTO dto = mapper.map(breed, BreedDTO.class);
		
		log.info("End - BreedServiceImpl.update - BreedRequest:{}", BreedRequest.class);
		return dto;
	}

	@Override
	public BreedDTO delete(Long id) {
		log.info("Start - BreedServiceImpl.delete - Id:{}", id);
		
		Breed breed = breedProcessor.exists(id);
		breedRepository.deleteById(id);
		BreedDTO dto = mapper.map(breed, BreedDTO.class);
		
		log.info("End - BreedServiceImpl.delete - Id:{}", BreedDTO.class);
		
		return dto;
	}
	
	

}
