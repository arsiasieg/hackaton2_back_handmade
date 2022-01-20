package com.handmade.hackatontwo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.handmade.hackatontwo.dto.TutorialDto;
import com.handmade.hackatontwo.model.Tutorial;
import com.handmade.hackatontwo.repository.TutorialRepository;

@RestController
@RequestMapping("/tutorials")
public class TutorialController {
	
	@Autowired
	TutorialRepository tutorialRepository;
	
	
	// Create
	
	@PostMapping
	public Tutorial create(@Valid @RequestBody TutorialDto tutorialDto ) {
		Tutorial tutorial = new Tutorial();
		tutorial.setDifficulty(tutorialDto.getDifficulty());
		tutorial.setImage(tutorialDto.getImage());
		tutorial.setTitle(tutorialDto.getTitle());	
		
		return tutorialRepository.save(tutorial);
	}
	
	// get All
	
	@GetMapping
	public List<Tutorial> getAll(){
		return tutorialRepository.findAll();
	}
	
	// Get one
	
	@GetMapping("/{id}")
	public Tutorial get(@PathVariable(required = true) Long id) {
		Optional<Tutorial> optTutorial = tutorialRepository.findById(id);
		if (optTutorial.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		return optTutorial.get();
		}
	
	// Update
	
	@PutMapping("/{id}")
	public Tutorial update(@PathVariable(required = true) Long id, @Valid @RequestBody TutorialDto tutorialDto) {
		Optional<Tutorial> optTutorial = tutorialRepository.findById(id);
		if(optTutorial.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		Tutorial tutorial = optTutorial.get();
		tutorial.setDifficulty(tutorialDto.getDifficulty());
		tutorial.setImage(tutorialDto.getImage());
		tutorial.setTitle(tutorialDto.getTitle());
		return tutorialRepository.save(tutorial);
	}
	
	// Delete
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable(required = true) Long id) {
		Optional<Tutorial> optTutorial = tutorialRepository.findById(id);
		if(optTutorial.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		tutorialRepository.deleteById(id);
	}
	

}
