package com.foster.pet.animal.service.processor;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.foster.pet.animal.entity.Health;
import com.foster.pet.animal.exception.HealthNotFoundException;
import com.foster.pet.animal.repository.HealthRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class HealthProcessor {

	@Autowired
	private HealthRepository repository;
	
	public Health exists(Long id) {
		log.info("Start - HealthProcessor.exists - Id:{}", id);
		
		Optional<Health> optional = repository.findById(id);
		if(optional.isEmpty()) {
			throw new HealthNotFoundException();
		}
		
		log.info("End - HealthProcessor.exists - Id:{}", id);
		
		return optional.get();
	}
	
}
