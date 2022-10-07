package com.author.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.author.Model.Author;
import com.author.service.IAuthorService;


@RestController
@RequestMapping( value ="/api/v1/digitalbooks")
@CrossOrigin(origins = "http://localhost:4200/")
public class AuthorController {

	@Autowired
	private IAuthorService authorService;
	
	@PostMapping("/author")
	public Integer addAuthor(@RequestBody Author author) {
		Integer aId = authorService.addAuthor(author);
		System.out.println(aId);
		return aId;
	}
	

}

