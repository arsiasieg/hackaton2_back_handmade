package com.handmade.hackatontwo.dto;

import javax.validation.constraints.NotBlank;

public class CategoryDto {

	@NotBlank
	private String name;

	// getters setters
	

	

	// getters setters



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
