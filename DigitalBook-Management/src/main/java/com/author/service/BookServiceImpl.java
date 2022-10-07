package com.author.service;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.author.Model.Author;
import com.author.Model.Book;
import com.author.dto.BookContentDto;
import com.author.dto.BookPaymentDto;
import com.author.dto.BookReaderDto;
import com.author.exception.RecordNotFoundException;
import com.author.repository.AuthorRepository;
import com.author.repository.IBookRepository;


@Service
public class BookServiceImpl implements IBookService {

	@Autowired
	private IBookRepository bookRepository;
	
	@Autowired
	private AuthorRepository authorRepository;
	
	//private final String Book_Available = "Available";
	//private final String Book_Blocked = "BLOCKED";
	
	
	@Override
	public Integer addBook(Integer aId, Book book) {
		Optional<Author> author = authorRepository.findById(aId);
		if(author.isPresent())
		{
			Author authorDb = author.get();
			book.setAuthor(authorDb);
			//book.setActive(Book_Available);
			return bookRepository.save(book).getBId();
			
		}
		else
		{
			throw new NoSuchElementException("Cannot add book, as no Author is found for the give Author ID");
		}
	}

//	@Override
//	public Book updateBook(Integer aId, Integer bId, Book book) {
//		Optional<Author> author = authorRepository.findById(aId);
//		if(author.isPresent())
//		{
//			Author authorDb = author.get();
//			book.setAuthor(authorDb);
//			Optional<Book> books = bookRepository.findById(bId);
//			if(books.isPresent())
//			{
//				return bookRepository.findById(bId);
//				
//			}
//		}
//		return null;
//	}
	
	@Override
	public Book updateBook(Integer aId, Book book, Integer bId) {
		Optional<Author> author = authorRepository.findById(aId);
		if(author.isPresent())
		{
			Book existingBook = bookRepository.findById(bId).orElseThrow(
					()-> new RecordNotFoundException("Book","bId", bId));
			existingBook.setActive(book.getActive());
		
			//we will update the value and then save the updated value
			bookRepository.save(existingBook);
			return existingBook;
		}
		return null;
	}

	
	@Override
	public List<Book> getBooksByCategoryAndPublisherAndAuthorNameAndPrice(String publisherName, String category,
			String authorName, double price) {
		return bookRepository.findByPublisherNameAndCategoryAndPriceAndAuthorName(publisherName, category, price, authorName);
	}
	
	
	@Override
	public List<Book> getBooksByTitle(String title) {
		
		List<Book> findByQueryMethod = bookRepository.findByQueryMethod(title);
		return findByQueryMethod;
	}

	

	@Override
	public List<BookReaderDto> simpleTest(String email) {
		List<BookReaderDto> findBooksDtoByEmail_Named = bookRepository.findBooksDtoByEmail_Named(email);
		return findBooksDtoByEmail_Named;
	}

	@Override
	public List<BookContentDto> getContent(String email, Integer bId) {
		List<BookContentDto> findBooksDtoByBookId_Names = bookRepository.findBooksDtoByBookId_Names(email,bId);
		return findBooksDtoByBookId_Names;
	}

	
	@Override
	public List<BookPaymentDto> getBooksByPaymentId(String email, Integer payId) {
		List<BookPaymentDto> findBookDtoByPayId_Named = bookRepository.findBookDtoByPayId_Named(email, payId);
		return findBookDtoByPayId_Named;
	}
	
	
	

	

	

	

	

	
	

}
