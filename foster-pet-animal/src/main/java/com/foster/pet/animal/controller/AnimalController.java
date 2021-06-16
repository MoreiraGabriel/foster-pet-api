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

import com.foster.pet.animal.dto.AnimalDTO;
import com.foster.pet.animal.request.AnimalRequest;
import com.foster.pet.animal.service.AnimalService;
import com.foster.pet.animal.util.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/animal")
@Api(value = "Controller para animal")
public class AnimalController {

	@Autowired
	private AnimalService animalService;
	
	@ApiOperation(value = "Endpoint para listar todas os animais.")
	@GetMapping
	public ResponseEntity<Response<Page<AnimalDTO>>> findAll(Pageable pageable){
		
		Response<Page<AnimalDTO>> response = new Response<>();
		
		Page<AnimalDTO> animals = animalService.findAll(pageable);		
		response.setData(animals);
		
		return ResponseEntity.ok(response);
	}
	
	@ApiOperation(value = "Endpoint para listar animal por id.")
	@GetMapping("{id}")
	public ResponseEntity<Response<AnimalDTO>> findById(@PathVariable Long id){
		
		Response<AnimalDTO> response = new Response<>();
		
		AnimalDTO animal = animalService.findById(id);		
		response.setData(animal);
		
		return ResponseEntity.ok(response);
	}
	
	@ApiOperation(value = "Endpoint para listar animal por nome.")
	@GetMapping(params = "name")
	public ResponseEntity<Response<List<AnimalDTO>>> findByName(@RequestParam String name){
		
		Response<List<AnimalDTO>> response = new Response<>();
		
		List<AnimalDTO> animals = animalService.findByName(name);		
		response.setData(animals);
		
		return ResponseEntity.ok(response);
	}
	
	@ApiOperation(value = "Endpoint para listar animal por tipo.")
	@GetMapping(params = "type")
	public ResponseEntity<Response<List<AnimalDTO>>> findByType(@RequestParam String type){
		
		Response<List<AnimalDTO>> response = new Response<>();
		
		List<AnimalDTO> animals = animalService.findByAnimalType(type);		
		response.setData(animals);
		
		return ResponseEntity.ok(response);
	}
	
	@ApiOperation(value = "Endpoint para cadastrar animal.")
	@PostMapping
	public ResponseEntity<Response<AnimalDTO>> create(@RequestBody AnimalRequest request) {
		Response<AnimalDTO> response = new Response<>();
		AnimalDTO animal = animalService.create(request);
		response.setData(animal);
		return ResponseEntity.ok(response);		
	}
	
	@ApiOperation(value = "Endpoint para atualizar animal.")
	@PutMapping
	public ResponseEntity<Response<AnimalDTO>> update(@RequestBody AnimalDTO request) {
		
		Response<AnimalDTO> response = new Response<>();
		
		AnimalDTO animal = animalService.update(request);
		response.setData(animal);
		
		return ResponseEntity.ok(response);		
	}
	
	@ApiOperation(value = "Endpoint para apagar por id.")
	@DeleteMapping("{id}")
	public ResponseEntity<Response<AnimalDTO>> delete(@PathVariable Long id) {
		Response<AnimalDTO> response = new Response<>();
		
		AnimalDTO animal = animalService.delete(id);
		response.setData(animal);
		
		return ResponseEntity.ok(response);		
	}
}
