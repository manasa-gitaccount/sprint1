package com.author.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.author.Model.Book;
import com.author.dto.BookContentDto;
import com.author.dto.BookPaymentDto;
import com.author.dto.BookReaderDto;
import com.author.exception.AuthorNotFoundException;
import com.author.exception.BookNotFoundException;
import com.author.service.IBookService;

@RestController
@RequestMapping("/api/v1/digitalbooks/")
public class BookController {

	@Autowired
	private IBookService bookService;
	
	

	//author can create book
	@PostMapping("author/{id}/book")
	public Integer addBook(@PathVariable Integer id, @RequestBody Book book)throws NullPointerException, SQLException, AuthorNotFoundException  {
		return bookService.addBook(id, book);
	}
	

	//author can edit book
	@PutMapping("author/{aId}/book/{bId}")
	public ResponseEntity<Book> updateBook(@PathVariable("aId") Integer aId, @RequestBody Book book, @PathVariable("bId") Integer bId)throws NullPointerException, SQLException, AuthorNotFoundException  {
		return new ResponseEntity<Book>(bookService.updateBook(aId, book, bId), HttpStatus.OK);
	}
	
	//reader can search book
	@GetMapping("books/search")
	public List<Book> getBooksByAuthor(@RequestParam String publisherName,@RequestParam String category,@RequestParam double  price , @RequestParam String authorName)
	{
		List<Book> booksByCategoryAndPublisherAndAuthorNameAndPrice = bookService.getBooksByCategoryAndPublisherAndAuthorNameAndPrice(publisherName, category, authorName, price);
		return booksByCategoryAndPublisherAndAuthorNameAndPrice;
	}

	
	
	//reader can find purchased book
	@GetMapping("readers/{email}/books")
	public List<BookReaderDto> getBooksSimple(@PathVariable String email)throws NullPointerException, SQLException,BookNotFoundException
	{
		return bookService.simpleTest(email);	
	}
	
	//reader can read  book
	@GetMapping("readers/{email}/books/{bId}")
	public List<BookContentDto> getContentBook(@PathVariable String email,@PathVariable Integer bId)throws NullPointerException, SQLException,BookNotFoundException
	{
		return bookService.getContent(email, bId);
	}
	
	
	@GetMapping("readers/{email}/book/{payId}")
	public List<BookPaymentDto> getbooksByPaymentId(@PathVariable String email,@PathVariable Integer payId)
	{
		return bookService.getBooksByPaymentId(email, payId) ;
	}
	
	
	
	
	
}
