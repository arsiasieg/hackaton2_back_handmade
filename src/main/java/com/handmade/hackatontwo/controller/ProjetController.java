package com.handmade.hackatontwo.controller;

import java.util.ArrayList;
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

import com.handmade.hackatontwo.dto.ProjetDto;
import com.handmade.hackatontwo.model.Product;
import com.handmade.hackatontwo.model.Projet;
import com.handmade.hackatontwo.model.Tutorial;
import com.handmade.hackatontwo.repository.ProductRepository;
import com.handmade.hackatontwo.repository.ProjetRepository;
import com.handmade.hackatontwo.repository.TutorialRepository;

@RestController
@RequestMapping("/projets")
public class ProjetController {
	@Autowired
	ProjetRepository projetRepository;

	@Autowired
	ProductRepository productRepository;
	@Autowired
	TutorialRepository tutorialRepository;

	@GetMapping
	public List<Projet> getProjets() {
		return projetRepository.findAll();
	}

	// Get one projet

	@GetMapping("/{id}")
	public Projet getProjet(@PathVariable(required = true) Long id) {
		/*
		 * try { return articleRepository.getById(id); } catch (Exception e) { throw new
		 * ResponseStatusException(HttpStatus.NOT_FOUND); }
		 */

		Optional<Projet> optProjet = projetRepository.findById(id);
		// Si mon objet optionnel contient bien un article, je le renvoi
		if (optProjet.isPresent()) {
			return optProjet.get();
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}

	// Create projet
	@PostMapping
	public Projet createProjet(@Valid @RequestBody ProjetDto projetDto) {
		List<Product> products = new ArrayList<>();

		for (Long productId : projetDto.getProductIds()) {
			Product product = productRepository.findById(productId)
					.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
			products.add(product);
		}

		List<Tutorial> tutorials = new ArrayList<>();

		for (Long tutorialId : projetDto.getTutorialIds()) {
			Tutorial tutorial = tutorialRepository.findById(tutorialId)
					.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
			tutorials.add(tutorial);
		}
		Projet projet = new Projet();
		projet.setName(projetDto.getName());
		projet.setBudget(projetDto.getBudget());
		projet.setProducts(products);
		projet.setTutorials(tutorials);
		return projetRepository.save(projet);
		// many to many tutorials

	}

	// Update

	@PutMapping("/{id}")
	public Projet updateProjet(@PathVariable(required = true) Long id, @Valid @RequestBody ProjetDto projetDto) {

		Optional<Projet> optProjet = projetRepository.findById(id);
		// Si mon objet optionnel ne contient pas d'article, je renvoi une erreur
		if (optProjet.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		// On modifie l'entité
		Projet projet = optProjet.get();
		projet.setName(projetDto.getName());
		projet.setBudget(projetDto.getBudget());

		// on enregistre l'entité enregistrée en DB
		return projetRepository.save(projet);
	}

	// Delete projet

	@DeleteMapping("/{id}")
	public void deleteProjet(@PathVariable(required = true) Long id) {
		Boolean exist = projetRepository.existsById(id);
		// Si mon objet optionnel ne contient pas de user, je renvoi une erreur
		if (!exist) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		projetRepository.deleteById(id);
	}

}
