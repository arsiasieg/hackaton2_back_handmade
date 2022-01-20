package com.handmade.hackatontwo.dto;

import java.util.List;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ProjetDto {
	@NotBlank
	@Size(min = 2, max = 100)
	private String name;

	@DecimalMin(value = "0.0", inclusive = false)
	@Digits(integer = 3, fraction = 2)
	private Float budget;
	// getters setters
	
	@Size(min=1)
	private List<Long> productIds;
private List<Long>tutorialIds;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getBudget() {
		return budget;
	}

	public void setBudget(Float budget) {
		this.budget = budget;
	}

	public List<Long> getProductIds() {
		return productIds;
	}

	public void setProductIds(List<Long> productIds) {
		this.productIds = productIds;
	}

	public List<Long> getTutorialIds() {
		return tutorialIds;
	}

	public void setTutorialIds(List<Long> tutorialIds) {
		this.tutorialIds = tutorialIds;
	}

}
