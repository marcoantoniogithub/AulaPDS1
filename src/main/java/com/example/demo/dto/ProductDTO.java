package com.example.demo.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;

import com.example.demo.entities.Product;


public class ProductDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	
	@NotEmpty(message = "can't be empty")
	@Length(min = 3, max = 80, message = "length must be between 3 and 80")
	private String name;

	@NotEmpty(message = "can't be empty")
	@Length(min = 8, message = "length must be between 5 and 80")
	private String description;
	

	@Positive
	private Double price;
	private String imgUrl;

	public ProductDTO() {
	}

	public ProductDTO(Long id, String name, String description, Double price, String imgUrl) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imgUrl = imgUrl;
	}

	public ProductDTO(Product entity) {
		setId(entity.getId());
		setName(entity.getName());
		setDescription(entity.getDescription());
		setPrice(entity.getPrice());
		setImgUrl(entity.getImgUrl());
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Product toEntity() {
		return new Product(id,name,description,price,imgUrl);
	}

}