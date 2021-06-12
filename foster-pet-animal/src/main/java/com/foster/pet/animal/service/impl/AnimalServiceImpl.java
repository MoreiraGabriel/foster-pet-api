package com.foster.pet.animal.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.foster.pet.animal.dto.AnimalDTO;
import com.foster.pet.animal.entity.Animal;
import com.foster.pet.animal.repository.AnimalRepository;
import com.foster.pet.animal.request.AnimalRequest;
import com.foster.pet.animal.service.AnimalService;
import com.foster.pet.animal.service.processor.AnimalProcessor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AnimalServiceImpl implements AnimalService{
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private AnimalProcessor processor;
	
	@Autowired
	private AnimalRepository animalRepository;

	@Override
	public Page<AnimalDTO> findAll(Pageable pageable) {
		log.info("Start - AnimalServiceImpl.findAll - Pageable:{}", pageable);
		
		Page<Animal> animals = animalRepository.findAll(pageable);
		Page<AnimalDTO> dtos = animals.map(animal -> mapper.map(animal, AnimalDTO.class));
		
		log.info("End - AnimalServiceImpl.findAll - Page<AnimalDTO>:{}", dtos.toString());
		
		return dtos;
	}

	@Override
	public AnimalDTO findById(Long id) {
		log.info("Start - AnimalServiceImpl.findById - Id:{}", id);
		Animal breed = processor.exists(id);
		AnimalDTO dto = mapper.map(breed, AnimalDTO.class);
		log.info("End -AnimalServiceImpl.findById - Id:{}", id);
		return dto;
	}

	@Override
	public List<AnimalDTO> findByName(String name) {
		log.info("Start - AnimalServiceImpl.findByName - Name:{}", name);
		List<Animal> listBreed = processor.exists(name);
		List<AnimalDTO> listDto = mapper.map(listBreed, new TypeToken<List<AnimalDTO>>() {}.getType());
		
		log.info("End - AnimalServiceImpl.findByName - Name:{}", name);
		return listDto;
	}

	@Override
	@Transactional
	public AnimalDTO create (AnimalRequest request) {
		log.info("Start - AnimalServiceImpl.create - AnimalRequest:{}", AnimalRequest.class);
		
		processor.alreadyExists(request.getName());
		
		final Animal animal = mapper.map(request, Animal.class);
		animal.getHealth().setAnimal(animal);
		
		animal.getHealth().getListIllness().stream().forEach(i -> i.setHealth(animal.getHealth()));
		animal.getHealth().getListVaccine().stream().forEach(v -> v.setHealth(animal.getHealth()));
		
		animal.getBreed().setAnimal(animal);
		
		Animal animalSave = animalRepository.save(animal);
		
		AnimalDTO dto = mapper.map(animalSave, AnimalDTO.class);
		
		log.info("End - AnimalServiceImpl.create - AnimalRequest:{}", AnimalRequest.class);
		return dto;
	}

	@Override
	@Transactional
	public AnimalDTO update(AnimalDTO request) {
		log.info("Start - AnimalServiceImpl.update - BreedRequest:{}", AnimalRequest.class);
		
		Animal animal = processor.exists(request.getId()); 
		
		animal = mapper.map(request, Animal.class);
		
		animal = animalRepository.save(animal);
		
		AnimalDTO dto = mapper.map(animal, AnimalDTO.class);
		
		log.info("End - AnimalServiceImpl.update - BreedRequest:{}", AnimalRequest.class);
		return dto;
	}

	@Override
	public AnimalDTO delete(Long id) {
		log.info("Start - AnimalServiceImpl.delete - Id:{}", id);
		
		Animal animal = processor.exists(id);
		animalRepository.deleteById(id);
		AnimalDTO dto = mapper.map(animal, AnimalDTO.class);
		
		log.info("End - AnimalServiceImpl.delete - Id:{}", AnimalDTO.class);
		
		return dto;
	}
	
}