package com.foster.pet.animal.service.processor;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.foster.pet.animal.entity.Breed;
import com.foster.pet.animal.exception.BreedAlreadyExistsException;
import com.foster.pet.animal.exception.BreedNotFoundException;
import com.foster.pet.animal.repository.BreedRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class BreedProcessor {

	@Autowired
	private BreedRepository breedRepository;
	
	public Breed exists(Long id) {
		log.info("Start - BreedProcessor.exists - Id:{}", id);
		
		Optional<Breed> optional = breedRepository.findById(id);
		if(optional.isEmpty()) {
			throw new BreedNotFoundException();
		}
		
		log.info("End - BreedProcessor.exists - Id:{}", id);
		
		return optional.get();
	}
	
	public List<Breed> exists(String name) {
		log.info("Start - BreedProcessor.exists - Name:{}", name);
		
		List<Breed> list = breedRepository.findByName(name);
		if(list.isEmpty()) {
			throw new BreedNotFoundException();
		}
		
		log.info("End - BreedProcessor.exists - Name:{}", name);
		
		return list;
	}
	
	public void alreadyExists(String name) {
		log.info("End - BreedProcessor.alreadyExists - Name:{}", name);
		
		List<Breed> list = breedRepository.findByName(name);
		if(!list.isEmpty()) {
			throw new BreedAlreadyExistsException();
		}
		
		log.info("End - BreedProcessor.alreadyExists - Name:{}", name);
	}
	
	
}
