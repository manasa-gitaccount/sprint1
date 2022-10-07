package com.kafka.entity;

public class Book {

	private String title;
	
	private String category;

	public Book() {
		super();
	}

	public Book(String title, String category) {
		super();
		this.title = title;
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
}
