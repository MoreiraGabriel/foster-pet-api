package com.foster.pet.animal.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.foster.pet.animal.dto.HealthDTO;
import com.foster.pet.animal.entity.Health;
import com.foster.pet.animal.repository.HealthRepository;
import com.foster.pet.animal.request.HealthRequest;
import com.foster.pet.animal.service.HealthService;
import com.foster.pet.animal.service.processor.HealthProcessor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class HealthServiceImpl implements HealthService {
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private HealthProcessor processor;
	
	@Autowired
	private HealthRepository repository;

	@Override
	public Page<HealthDTO> findAll(Pageable pageable) {
		log.info("Start - HealthServiceImpl.findAll - Pageable:{}", pageable);
		
		Page<Health> healths = repository.findAll(pageable);
		Page<HealthDTO> dtos = healths.map(health -> mapper.map(health, HealthDTO.class));
		
		log.info("End - HealthServiceImpl.findAll - Page<HealthDTO>:{}", dtos.toString());
		
		return dtos;
	}

	@Override
	public HealthDTO findById(Long id) {
		log.info("Start - HealthServiceImpl.findById - Id:{}", id);
		Health health = processor.exists(id);
		HealthDTO dto = mapper.map(health, HealthDTO.class);
		log.info("End -HealthServiceImpl.findById - Id:{}", id);
		return dto;
	}

	@Override
	public List<HealthDTO> findByAnimal_Name(String name) {
		log.info("Start - HealthServiceImpl.findByName - Name:{}", name);
		
		List<Health> healths = repository.findByAnimal_Name(name);
		List<HealthDTO> dtos = mapper.map(healths, new TypeToken<List<HealthDTO>>() {}.getType());		
		log.info("End - HealthServiceImpl.findByName - Name:{}", dtos.toString());
		
		return dtos;
	}

	@Override
	public HealthDTO create(HealthRequest request) {
		log.info("Start - HealthServiceImpl.create - HealthRequest:{}", HealthRequest.class);
		
		final Health health = mapper.map(request, Health.class);
		
		health.getListIllness().stream().forEach(i -> i.setHealth(health));
		
		health.getListVaccine().stream().forEach(v->v.setHealth(health));
		
		Health healthSave = repository.save(health);
		
		HealthDTO dto = mapper.map(healthSave, HealthDTO.class);
		
		log.info("End - HealthServiceImpl.create - HealthRequest:{}", HealthRequest.class);
		return dto;
	}

	@Override
	public HealthDTO update(Long id, HealthRequest request) {
		log.info("Start - HealthServiceImpl.create - HealthRequest:{}", HealthRequest.class);
		
		Health health =  processor.exists(id);
		
		health = mapper.map(request, Health.class);
		health = repository.save(health);
		
		HealthDTO dto = mapper.map(health, HealthDTO.class);
		
		log.info("End - HealthServiceImpl.create - HealthRequest:{}", HealthRequest.class);
		return dto;
	}

	@Override
	public HealthDTO delete(Long id) {
		log.info("Start - HealthServiceImpl.delete - Id:{}", id);
		
		Health health = processor.exists(id);
		repository.deleteById(id);
		HealthDTO dto = mapper.map(health, HealthDTO.class);
		
		log.info("End - HealthServiceImpl.delete - Id:{}", HealthDTO.class);
		
		return dto;
	}

}
