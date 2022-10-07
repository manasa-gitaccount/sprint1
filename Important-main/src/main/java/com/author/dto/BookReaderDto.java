package com.author.dto;

import java.util.Date;


public class BookReaderDto {

	
	private String logo;
	private String title;
	private String category;
	private String author_name;
	private String publisher_name;
	//@Temporal(TemporalType.DATE)
	private Date published_date;
	private String active;
	private double price;
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
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
	public String getAuthor_name() {
		return author_name;
	}
	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}
	public String getPublisher_name() {
		return publisher_name;
	}
	public void setPublisher_name(String publisher_name) {
		this.publisher_name = publisher_name;
	}
	public Date getPublished_date() {
		return published_date;
	}
	public void setPublished_date(Date published_date) {
		this.published_date = published_date;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public BookReaderDto(String logo, String title, String category, String author_name, String publisher_name,
			Date published_date, String active, double price) {
		super();
		this.logo = logo;
		this.title = title;
		this.category = category;
		this.author_name = author_name;
		this.publisher_name = publisher_name;
		this.published_date = published_date;
		this.active = active;
		this.price = price;
	}
	
	public BookReaderDto(String category, String author_name ,String title,String logo ,String active ,double price,String publisher_name ,Date published_date) {
		super();
		this.category = category;
		this.author_name = author_name;
		this.title=title;
		this.logo=logo;
		this.active=active;
		this.price=price;
		this.publisher_name=publisher_name;
		this.published_date=published_date;
		
	}
	public BookReaderDto(String category) {
		super();
		this.category = category;
	}
	
	
	
}
