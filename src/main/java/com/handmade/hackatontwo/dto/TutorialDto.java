package com.handmade.hackatontwo.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class TutorialDto {

	
	@NotBlank
	@Size(min=2, max=100)
	private String title;
	
	@NotBlank
	@Min(value = 0)
	private Integer difficulty;
	
	@NotBlank
	@Size(min=2, max=255)
	private String image;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Integer difficulty) {
		this.difficulty = difficulty;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
