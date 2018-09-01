package com.springbootmongodbsample.springbootmongoDBsample.controllers;

import java.util.List;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootmongodbsample.springbootmongoDBsample.model.Pets;
import com.springbootmongodbsample.springbootmongoDBsample.repositories.PetsDao;

@RestController
@RequestMapping("/Pets")
public class PetsController {

	private PetsDao repository;

	@Autowired
	public PetsController(PetsDao dao) {
		this.repository = dao;
	}

	@GetMapping(value = "/")
	public List<Pets> getAllPets() {
		return repository.findAll();
	}

	@GetMapping(value = "/{id}")
	public Pets getPetsById(@PathVariable("id") ObjectId id) {
		return repository.findById(id);
	}

	@PostMapping(value = "/")
	public ResponseEntity<?> addPet(@Valid @RequestBody Pets pet) {
		repository.save(pet);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> modifyPetById(@PathVariable("id") ObjectId id, @Valid @RequestBody Pets pet) {
		try {
			repository.save(pet);
		} catch (final Exception ex) {
			
		}
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") ObjectId id) {
		repository.delete(repository.findById(id));
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

}
