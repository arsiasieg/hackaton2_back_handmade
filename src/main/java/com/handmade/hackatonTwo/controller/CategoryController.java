package com.handmade.hackatonTwo.controller;

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

import com.handmade.hackatonTwo.dto.CategoryDto;

import com.handmade.hackatonTwo.model.Category;

import com.handmade.hackatonTwo.repository.CategoryRepository;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	@Autowired
	CategoryRepository categoryRepository;

	@GetMapping
	public  List<Category> getCategories() {
		return categoryRepository.findAll();
	}

	// Get one category

	@GetMapping("/{id}")
	public Category getCategory(@PathVariable(required = true) Long id) {
		/*
		 * try { return articleRepository.getById(id); } catch (Exception e) { throw new
		 * ResponseStatusException(HttpStatus.NOT_FOUND); }
		 */

		Optional<Category> optCategory = categoryRepository.findById(id);
		// Si mon objet optionnel contient bien un article, je le renvoi
		if (optCategory.isPresent()) {
			return optCategory.get();
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}

	// Create category
	@PostMapping
	public Category createCategory(@Valid @RequestBody CategoryDto categoryDto) {
		Category category = new Category();
		category.setName(categoryDto.getName());

		return categoryRepository.save(category);
	}

	// Update

	@PutMapping("/{id}")
	public Category updateCategory(@PathVariable(required = true) Long id,
			@Valid @RequestBody CategoryDto categoryDto) {

		Optional<Category> optCategory = categoryRepository.findById(id);
		// Si mon objet optionnel ne contient pas d'article, je renvoi une erreur
		if (optCategory.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		// On modifie l'entité
		Category category = optCategory.get();
		category.setName(categoryDto.getName());

		// on enregistre l'entité enregistrée en DB
		return categoryRepository.save(category);
	}

	// Delete projet

	@DeleteMapping("/{id}")
	public void deleteCategory(@PathVariable(required = true) Long id) {
		Boolean exist = categoryRepository.existsById(id);
		// Si mon objet optionnel ne contient pas de user, je renvoi une erreur
		if (!exist) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		categoryRepository.deleteById(id);
	}

}
