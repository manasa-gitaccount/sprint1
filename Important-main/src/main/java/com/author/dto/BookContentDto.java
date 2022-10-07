package com.author.dto;

public class BookContentDto {

	
	private String category;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public BookContentDto(String category) {
		super();
		this.category = category;
	}
	
	
}
