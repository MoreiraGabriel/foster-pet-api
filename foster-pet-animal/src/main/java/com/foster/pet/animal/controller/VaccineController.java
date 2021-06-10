package com.foster.pet.animal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foster.pet.animal.dto.VaccineDTO;
import com.foster.pet.animal.request.VaccineRequest;
import com.foster.pet.animal.service.VaccineService;
import com.foster.pet.animal.util.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("vaccine")
@Api(value = "Controller para vacine")
public class VaccineController {
	
	@Autowired
	private VaccineService service;
	
	@ApiOperation(value = "Endpoint para listar todas as raças.")
	@GetMapping
	public ResponseEntity<Response<Page<VaccineDTO>>> findAll(Pageable pageable){
		
		Response<Page<VaccineDTO>> response = new Response<>();
		
		Page<VaccineDTO> vaccines = service.findAll(pageable);		
		response.setData(vaccines);
		
		return ResponseEntity.ok(response);
	}
	
	@ApiOperation(value = "Endpoint para listar raça por id.")
	@GetMapping("{id}")
	public ResponseEntity<Response<VaccineDTO>> findById(@PathVariable Long id){
		
		Response<VaccineDTO> response = new Response<>();
		
		VaccineDTO vaccine = service.findById(id);		
		response.setData(vaccine);
		
		return ResponseEntity.ok(response);
	}
	
	@ApiOperation(value = "Endpoint para listar raça por nome.")
	@GetMapping(params = "name")
	public ResponseEntity<Response<List<VaccineDTO>>> findByName(@RequestParam String name){
		
		Response<List<VaccineDTO>> response = new Response<>();
		
		List<VaccineDTO> vaccine = service.findByName(name);		
		response.setData(vaccine);
		
		return ResponseEntity.ok(response);
	}
	
	@ApiOperation(value = "Endpoint para cadastrar raça.")
	@PostMapping
	public ResponseEntity<Response<VaccineDTO>> create(@RequestBody VaccineRequest request) {
		Response<VaccineDTO> response = new Response<>();
		VaccineDTO vaccine = service.create(request);
		response.setData(vaccine);
		return ResponseEntity.ok(response);		
	}
	
	@ApiOperation(value = "Endpoint para atualizar raça.")
	@PutMapping("{id}")
	public ResponseEntity<Response<VaccineDTO>> update(@PathVariable Long id, @RequestBody VaccineRequest request) {
		Response<VaccineDTO> response = new Response<>();
		
		VaccineDTO vaccine = service.update(id, request);
		response.setData(vaccine);
		
		return ResponseEntity.ok(response);		
	}
	
	@ApiOperation(value = "Endpoint para listar apagar por id.")
	@DeleteMapping("{id}")
	public ResponseEntity<Response<VaccineDTO>> delete(@PathVariable Long id) {
		Response<VaccineDTO> response = new Response<>();
		
		VaccineDTO vaccine = service.delete(id);
		response.setData(vaccine);
		
		return ResponseEntity.ok(response);		
	}

}
