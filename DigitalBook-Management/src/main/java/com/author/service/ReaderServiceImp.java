package com.author.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.author.Model.Book;
import com.author.Model.Reader;
import com.author.repository.IBookRepository;
import com.author.repository.ReaderRepository;

@Service
public class ReaderServiceImp  implements ReaderService{

	@Autowired
	IBookRepository bookRepository;
	
	@Autowired
	ReaderRepository readerRepository;
	
	@Override
	public Integer addReader(Reader reader, Integer bId) {
		Optional<Book> book = bookRepository.findById(bId);
		if(book.isPresent())
		{
			Book bookDb = book.get();
			reader.setBook(bookDb);
			
			return readerRepository.save(reader).getrId();
			
		}
		else
		{
			throw new NoSuchElementException("Cannot add book, as no book  is found for the give Book ID");
		}
	}

	@Override
	public List<Reader> findRefund(String email, Integer bId) {
		return readerRepository.findByPurchaseTimeWithEmailAndBookId(email, bId);
	
	}

}



	
	
	


