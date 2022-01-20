package com.handmade.hackatontwo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Size(min = 2, max = 100)
	
	@OneToMany(mappedBy = "category")
	private List<Tutorial> tutorials;
	
	// getters setters

	private String name;

	@OneToMany(mappedBy="category")
	private List<Product> products;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;}

	public List<Tutorial> getTutorials() {
		return tutorials;
	}

	public void setTutorials(List<Tutorial> tutorials) {
		this.tutorials = tutorials;

	}

}
