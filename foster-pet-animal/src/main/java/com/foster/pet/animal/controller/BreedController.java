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

import com.foster.pet.animal.dto.BreedDTO;
import com.foster.pet.animal.request.BreedRequest;
import com.foster.pet.animal.service.BreedService;
import com.foster.pet.animal.util.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/breed")
@Api(value = "Controller para raça")
public class BreedController {
	
	@Autowired
	BreedService breedService;
	
	@ApiOperation(value = "Endpoint para listar todas as raças.")
	@GetMapping
	public ResponseEntity<Response<Page<BreedDTO>>> findAll(Pageable pageable){
		
		Response<Page<BreedDTO>> response = new Response<>();
		
		Page<BreedDTO> breeds = breedService.findAll(pageable);		
		response.setData(breeds);
		
		return ResponseEntity.ok(response);
	}
	
	@ApiOperation(value = "Endpoint para listar raça por id.")
	@GetMapping("{id}")
	public ResponseEntity<Response<BreedDTO>> findById(@PathVariable Long id){
		
		Response<BreedDTO> response = new Response<>();
		
		BreedDTO breed = breedService.findById(id);		
		response.setData(breed);
		
		return ResponseEntity.ok(response);
	}
	
	@ApiOperation(value = "Endpoint para listar raça por nome.")
	@GetMapping(params = "name")
	public ResponseEntity<Response<List<BreedDTO>>> findByName(@RequestParam String name){
		
		Response<List<BreedDTO>> response = new Response<>();
		
		List<BreedDTO> breed = breedService.findByName(name);		
		response.setData(breed);
		
		return ResponseEntity.ok(response);
	}
	
	@ApiOperation(value = "Endpoint para cadastrar raça.")
	@PostMapping
	public ResponseEntity<Response<BreedDTO>> create(@RequestBody BreedRequest request) {
		Response<BreedDTO> response = new Response<>();
		BreedDTO breed = breedService.create(request);
		response.setData(breed);
		return ResponseEntity.ok(response);		
	}
	
	@ApiOperation(value = "Endpoint para atualizar raça.")
	@PutMapping
	public ResponseEntity<Response<BreedDTO>> update(@RequestBody BreedDTO request) {
		Response<BreedDTO> response = new Response<>();
		
		BreedDTO breed = breedService.update(request);
		response.setData(breed);
		
		return ResponseEntity.ok(response);		
	}
	
	@ApiOperation(value = "Endpoint para apagar por id.")
	@DeleteMapping("{id}")
	public ResponseEntity<Response<BreedDTO>> delete(@PathVariable Long id) {
		Response<BreedDTO> response = new Response<>();
		
		BreedDTO breed = breedService.delete(id);
		response.setData(breed);
		
		return ResponseEntity.ok(response);		
	}

}
