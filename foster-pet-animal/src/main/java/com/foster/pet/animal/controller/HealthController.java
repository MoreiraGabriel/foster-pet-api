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

import com.foster.pet.animal.dto.HealthDTO;
import com.foster.pet.animal.request.HealthRequest;
import com.foster.pet.animal.service.HealthService;
import com.foster.pet.animal.util.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("health")
@Api(value = "Controller para saúde")
public class HealthController {
	
	@Autowired
	private HealthService service;
	
	@ApiOperation(value = "Endpoint para listar todas as raças.")
	@GetMapping
	public ResponseEntity<Response<Page<HealthDTO>>> findAll(Pageable pageable){
		
		Response<Page<HealthDTO>> response = new Response<>();
		
		Page<HealthDTO> vaccines = service.findAll(pageable);		
		response.setData(vaccines);
		
		return ResponseEntity.ok(response);
	}
	
	@ApiOperation(value = "Endpoint para listar saúde por id.")
	@GetMapping("{id}")
	public ResponseEntity<Response<HealthDTO>> findById(@PathVariable Long id){
		
		Response<HealthDTO> response = new Response<>();
		
		HealthDTO health = service.findById(id);		
		response.setData(health);
		
		return ResponseEntity.ok(response);
	}
	
	@ApiOperation(value = "Endpoint para listar saúde por animal.")
	@GetMapping(params = "name")
	public ResponseEntity<Response<List<HealthDTO>>> findByName(@RequestParam String name){
		
		Response<List<HealthDTO>> response = new Response<>();
		
		List<HealthDTO> health = service.findByAnimal_Name(name);		
		response.setData(health);
		
		return ResponseEntity.ok(response);
	}
	
	@ApiOperation(value = "Endpoint para cadastrar saúde.")
	@PostMapping
	public ResponseEntity<Response<HealthDTO>> create(@RequestBody HealthRequest request) {
		Response<HealthDTO> response = new Response<>();
		HealthDTO health = service.create(request);
		response.setData(health);
		return ResponseEntity.ok(response);		
	}
	
	@ApiOperation(value = "Endpoint para atualizar saúde.")
	@PutMapping("{id}")
	public ResponseEntity<Response<HealthDTO>> update(@PathVariable Long id, @RequestBody HealthRequest request) {
		Response<HealthDTO> response = new Response<>();
		
		HealthDTO vaccine = service.update(id, request);
		response.setData(vaccine);
		
		return ResponseEntity.ok(response);		
	}
	
	@ApiOperation(value = "Endpoint para apagar por id.")
	@DeleteMapping("{id}")
	public ResponseEntity<Response<HealthDTO>> delete(@PathVariable Long id) {
		Response<HealthDTO> response = new Response<>();
		
		HealthDTO health = service.delete(id);
		response.setData(health);
		
		return ResponseEntity.ok(response);		
	}

}
