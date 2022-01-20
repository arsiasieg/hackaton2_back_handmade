package com.handmade.hackatontwo.controller;




import java.util.List;

import java.util.Optional;

import javax.validation.Valid;

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
import org.springframework.web.server.ResponseStatusException;

import com.handmade.hackatontwo.dto.ProductDto;
import com.handmade.hackatontwo.model.Product;
import com.handmade.hackatontwo.repository.ProductRepository;


@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	ProductRepository productRepository;
	

	// Create
	@PostMapping
	public Product create(@Valid @RequestBody ProductDto productDto) {
		
		//creation liste de categories qu'on veut associée au nouveau produit. 
		//List<Category> categories = new ArrayList<>();
		
		//pour chaque ID categorie envoyé dans la productDto
		//for (Long categoryId : productDto.getcategoryId()) {
			
			//on verifie si la categorie est existante
			
			//Optional<Category> optCategory = categoryRepository.findById(categoryId);
			//if (optCategory.isPresent()) {
				
				//si existanteon la place dans la liste de cat' associé au product
				//categories.add(optCategory.get());
			//}else {
			//	throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			//}
		
		Product product = new Product();
		product.setName(productDto.getName());
		product.setPrice(productDto.getPrice());
		product.setImage(productDto.getImage());
		product.setIsBy(productDto.getIsBy());

			return productRepository.save(product);
	}
	
	// Get one 
		@GetMapping("/{id}")
		public Product get(@PathVariable (required = true) Long id) {
			Optional<Product> optProduct = productRepository.findById(id);
			if(optProduct.isPresent()) {
				return optProduct.get();
			}
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
			
		}
		
		// Get all
		@GetMapping
		public List<Product> getProducts() {
			return productRepository.findAll();
			
		}
		
		// Update
		@PutMapping("/{id}")
		public Product update(@PathVariable (required = true) Long id, @Valid @RequestBody ProductDto productDto ) {
			Optional<Product> optProduct = productRepository.findById(id);
			if(optProduct.isEmpty()) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
			}
			Product product = optProduct.get();
			product.setName(productDto.getName());
			product.setPrice(productDto.getPrice());
			product.setImage(productDto.getImage());
			product.setIsBy(productDto.getIsBy());
				return productRepository.save(product);
			
		}
		
		//Delete one
		@DeleteMapping("/{id}")
		public ResponseEntity<?> delete(@PathVariable (required = true) long id) {
			Boolean exist = productRepository.existsById(id);
			if(!exist) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			}
			productRepository.deleteById(id);
				return new ResponseEntity<>(HttpStatus.OK);
		}
}
