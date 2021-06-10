package com.foster.pet.animal.service.processor;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.foster.pet.animal.entity.Vaccine;
import com.foster.pet.animal.exception.BreedNotFoundException;
import com.foster.pet.animal.exception.VaccineAlreadyExistsException;
import com.foster.pet.animal.exception.VaccineNotFoundException;
import com.foster.pet.animal.repository.VaccineRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class VaccineProcessor {

	@Autowired
	private VaccineRepository repository;
	
	public Vaccine exists(Long id) {
		log.info("Start - VaccineProcessor.exists - Id:{}", id);
		
		Optional<Vaccine> optional = repository.findById(id);
		if(optional.isEmpty()) {
			throw new BreedNotFoundException();
		}
		
		log.info("End - VaccineProcessor.exists - Id:{}", id);
		
		return optional.get();
	}
	
	public List<Vaccine> exists(String name) {
		log.info("Start - VaccineProcessor.exists - Name:{}", name);
		
		List<Vaccine> list = repository.findByName(name);
		if(list.isEmpty()) {
			throw new VaccineNotFoundException();
		}
		
		log.info("End - VaccineProcessor.exists - Name:{}", name);
		
		return list;
	}
	
	public void alreadyExists(String name) {
		log.info("End - VaccineProcessor.alreadyExists - Name:{}", name);
		
		List<Vaccine> list = repository.findByName(name);
		if(!list.isEmpty()) {
			throw new VaccineAlreadyExistsException();
		}
		
		log.info("End - VaccineProcessor.alreadyExists - Name:{}", name);
	}
	
}
