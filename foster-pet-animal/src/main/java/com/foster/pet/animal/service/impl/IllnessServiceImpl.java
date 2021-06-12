package com.foster.pet.animal.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.foster.pet.animal.dto.IllnessDTO;
import com.foster.pet.animal.dto.VaccineDTO;
import com.foster.pet.animal.entity.Illness;
import com.foster.pet.animal.repository.IllnessRepository;
import com.foster.pet.animal.request.IllnessRequest;
import com.foster.pet.animal.service.IllnessService;
import com.foster.pet.animal.service.processor.IllnessProcessor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class IllnessServiceImpl implements IllnessService {
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private IllnessProcessor processor;
	
	@Autowired
	private IllnessRepository repository;

	@Override
	public IllnessDTO findById(Long id) {
		log.info("Start - IllnessServiceImpl.findById - Id:{}", id);
		Illness illness = processor.exists(id);
		IllnessDTO dto = mapper.map(illness, IllnessDTO.class);
		log.info("End -IllnessServiceImpl.findById - Id:{}", id);
		return dto;
	}

	@Override
	public List<IllnessDTO> findByName(String name) {
		log.info("Start - IllnessServiceImpl.findByName - Id:{}", name);
		List<Illness> listIllness = processor.exists(name);		
		List<IllnessDTO> listDto = mapper.map(listIllness, new TypeToken<List<IllnessDTO>>( ) {}.getType());
		log.info("End -IllnessServiceImpl.findByName - Id:{}", name);
		return listDto;
	}

	@Override
	public Page<IllnessDTO> findAll(Pageable pageable) {
		log.info("Start - IllnessServiceImpl.findAll - Pageable:{}", pageable);
		
		Page<Illness> listIllness = repository.findAll(pageable);
		Page<IllnessDTO> dtos = listIllness.map(illness -> mapper.map(illness, IllnessDTO.class));
		
		log.info("End - IllnessServiceImpl.findAll - Page<IllnessDTO>:{}", dtos.toString());
		
		return dtos;
	}

	@Override
	public IllnessDTO create(IllnessRequest request) {
		log.info("Start - IllnessServiceImpl.create - IllnessRequest:{}", IllnessRequest.class);
		
		processor.alreadyExists(request.getName());
		
		Illness illness = mapper.map(request, Illness.class);
		illness = repository.save(illness);
		
		IllnessDTO dto = mapper.map(illness, IllnessDTO.class);
		
		log.info("End - IllnessServiceImpl.create - IllnessRequest:{}", IllnessDTO.class);
		return dto;
	}

	@Override
	public IllnessDTO update(IllnessDTO request) {
		log.info("Start - IllnessServiceImpl.update - IllnessRequest:{}", IllnessRequest.class);
		
		Illness illness =  processor.exists(request.getId());
		illness.setName(request.getName());	
		
		illness = repository.save(illness);
		
		IllnessDTO dto = mapper.map(illness, IllnessDTO.class);
		
		log.info("End - IllnessServiceImpl.update - IllnessDTO:{}", IllnessDTO.class);
		return dto;
	}

	@Override
	public IllnessDTO delete(Long id) {
		log.info("Start - IllnessServiceImpl.delete - Id:{}", id);
		
		Illness illness = processor.exists(id);
		repository.deleteById(id);
		IllnessDTO dto = mapper.map(illness, IllnessDTO.class);
		
		log.info("End - IllnessServiceImpl.delete - Id:{}", VaccineDTO.class);
		
		return dto;
	}

}
