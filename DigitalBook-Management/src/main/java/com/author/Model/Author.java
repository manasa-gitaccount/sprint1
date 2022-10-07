package com.author.Model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class Author {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer aId;

	private String authorName;

	@OneToMany(mappedBy = "author")
	@JsonManagedReference
	private List<Book> books;

	public Integer getAId() {
		return aId;
	}

	public void setAId(Integer aId) {
		this.aId = aId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Author(Integer aId, String authorName, List<Book> books) {
		super();
		this.aId = aId;
		this.authorName = authorName;
		this.books = books;
	}

	public Author() {
		super();
	}
	
}
