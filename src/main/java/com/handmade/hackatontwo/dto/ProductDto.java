package com.handmade.hackatontwo.dto;

import javax.persistence.Basic;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ProductDto {
	@NotBlank
	@Size(min=2, max = 255)
	private String name;
	
	@DecimalMin(value = "0.0", inclusive = false)
	@Digits(integer=3, fraction=2)
	private Float price;
	

    @Basic(fetch=FetchType.LAZY)
	private String image;
	
	private Boolean isBy;
	private Long category_id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Boolean getIsBy() {
		return isBy;
	}

	public void setIsBy(Boolean isBy) {
		this.isBy = isBy;
	}

	public Long getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}

}
