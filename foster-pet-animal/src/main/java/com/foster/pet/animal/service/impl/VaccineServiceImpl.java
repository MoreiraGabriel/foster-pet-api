package com.foster.pet.animal.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.foster.pet.animal.dto.VaccineDTO;
import com.foster.pet.animal.entity.Vaccine;
import com.foster.pet.animal.repository.VaccineRepository;
import com.foster.pet.animal.request.VaccineRequest;
import com.foster.pet.animal.service.VaccineService;
import com.foster.pet.animal.service.processor.VaccineProcessor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class VaccineServiceImpl implements VaccineService {
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private VaccineProcessor processor;
	
	@Autowired
	private VaccineRepository repository;

	@Override
	public VaccineDTO findById(Long id) {
		log.info("Start - VaccineServiceImpl.findById - Id:{}", id);
		Vaccine vaccine = processor.exists(id);
		VaccineDTO dto = mapper.map(vaccine, VaccineDTO.class);
		log.info("End -VaccineServiceImpl.findById - Id:{}", id);
		return dto;
	}

	@Override
	public List<VaccineDTO> findByName(String name) {
		log.info("Start - VaccineServiceImpl.findByName - Name:{}", name);
		
		List<Vaccine> vaccines = repository.findByName(name);
		List<VaccineDTO> dtos = mapper.map(vaccines, new TypeToken<List<VaccineDTO>>() {}.getType());		
		log.info("End - VaccineServiceImpl.findByName - Name:{}", dtos.toString());
		
		return dtos;
	}
	
	@Override
	public Page<VaccineDTO> findAll(Pageable pageable) {
		log.info("Start - VaccineServiceImpl.findAll - Pageable:{}", pageable);
		
		Page<Vaccine> vaccines = repository.findAll(pageable);
		Page<VaccineDTO> dtos = vaccines.map(vaccine -> mapper.map(vaccine, VaccineDTO.class));
		
		log.info("End - VaccineServiceImpl.findAll - Page<VaccineDTO>:{}", dtos.toString());
		
		return dtos;
	}

	@Override
	public VaccineDTO create(VaccineRequest request) {
		log.info("Start - VaccineServiceImpl.create - VaccineRequest:{}", VaccineRequest.class);
		
		processor.alreadyExists(request.getName());
		
		Vaccine vaccine = mapper.map(request, Vaccine.class);
		vaccine = repository.save(vaccine);
		
		VaccineDTO dto = mapper.map(vaccine, VaccineDTO.class);
		
		log.info("End - VaccineServiceImpl.create - VaccineRequest:{}", VaccineRequest.class);
		return dto;
	}

	@Override
	public VaccineDTO update(VaccineDTO request) {
		log.info("Start - VaccineServiceImpl.update - VaccineRequest:{}", VaccineRequest.class);
		
		Vaccine vaccine =  processor.exists(request.getId());
		vaccine.setName(request.getName());	
		
		vaccine = repository.save(vaccine);
		
		VaccineDTO dto = mapper.map(vaccine, VaccineDTO.class);
		
		log.info("End - VaccineServiceImpl.update - VaccineDTO:{}", VaccineDTO.class);
		return dto;
	}

	@Override
	public VaccineDTO delete(Long id) {
		log.info("Start - VaccineServiceImpl.delete - Id:{}", id);
		
		Vaccine vaccine = processor.exists(id);
		repository.deleteById(id);
		VaccineDTO dto = mapper.map(vaccine, VaccineDTO.class);
		
		log.info("End - VaccineServiceImpl.delete - Id:{}", VaccineDTO.class);
		
		return dto;
	}

}
