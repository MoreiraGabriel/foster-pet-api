package com.foster.pet.animal.service.processor;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.foster.pet.animal.entity.Animal;
import com.foster.pet.animal.exception.AnimalAlreadyExistsException;
import com.foster.pet.animal.exception.AnimalNotFoundException;
import com.foster.pet.animal.repository.AnimalRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AnimalProcessor {

	@Autowired
	private AnimalRepository repository;
	
	public Animal exists(Long id) {
		log.info("Start - AnimalProcessor.exists - Id:{}", id);
		
		Optional<Animal> optional = repository.findById(id);
		if(optional.isEmpty()) {
			throw new AnimalNotFoundException();
		}
		
		log.info("End - AnimalProcessor.exists - Id:{}", id);
		
		return optional.get();
	}
	
	public List<Animal> exists(String name) {
		log.info("Start - AnimalProcessor.exists - Name:{}", name);
		
		List<Animal> list = repository.findByName(name);
		if(list.isEmpty()) {
			throw new AnimalNotFoundException();
		}
		
		log.info("End - AnimalProcessor.exists - Name:{}", name);
		
		return list;
	}
	
	public void alreadyExists(String name) {
		log.info("End - AnimalProcessor.alreadyExists - Name:{}", name);
		
		List<Animal> list = repository.findByName(name);
		if(!list.isEmpty()) {
			throw new AnimalAlreadyExistsException();
		}
		
		log.info("End - AnimalProcessor.alreadyExists - Name:{}", name);
	}
	
	
}
