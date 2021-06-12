package com.foster.pet.animal.service.processor;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.foster.pet.animal.entity.Illness;
import com.foster.pet.animal.exception.BreedNotFoundException;
import com.foster.pet.animal.exception.IllnessAlreadyExistsException;
import com.foster.pet.animal.exception.IllnessNotFoundException;
import com.foster.pet.animal.repository.IllnessRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class IllnessProcessor {

	@Autowired
	private IllnessRepository repository;
	
	public Illness exists(Long id) {
		log.info("Start - IllnessProcessor.exists - Id:{}", id);
		
		Optional<Illness> optional = repository.findById(id);
		if(optional.isEmpty()) {
			throw new BreedNotFoundException();
		}
		
		log.info("End - IllnessProcessor.exists - Id:{}", id);
		
		return optional.get();
	}
	
	public List<Illness> exists(String name) {
		log.info("Start - IllnessProcessor.exists - Name:{}", name);
		
		List<Illness> list = repository.findByName(name);
		if(list.isEmpty()) {
			throw new IllnessNotFoundException();
		}
		
		log.info("End - IllnessProcessor.exists - Name:{}", name);
		
		return list;
	}
	
	public void alreadyExists(String name) {
		log.info("End - IllnessProcessor.alreadyExists - Name:{}", name);
		
		List<Illness> list = repository.findByName(name);
		if(!list.isEmpty()) {
			throw new IllnessAlreadyExistsException();
		}
		
		log.info("End - IllnessProcessor.alreadyExists - Name:{}", name);
	}
	
}
