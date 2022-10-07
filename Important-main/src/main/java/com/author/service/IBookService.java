package com.author.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.author.Model.Book;
import com.author.dto.BookContentDto;
import com.author.dto.BookPaymentDto;
import com.author.dto.BookReaderDto;

@Service
public interface IBookService {

	public Integer addBook(Integer aId, Book book);
	
	public Book updateBook(Integer aId, Book book, Integer bId);
	
	public List<Book> getBooksByTitle(String title);
	
	public List<Book> getBooksByCategoryAndPublisherAndAuthorNameAndPrice(String publisherName,String category,String authorName,double price);
	

	
	public List<BookReaderDto> simpleTest(String email);
	
	public List<BookContentDto> getContent(String email, Integer bId);
	
	public List<BookPaymentDto> getBooksByPaymentId(String email, Integer payId);

	
	
}
