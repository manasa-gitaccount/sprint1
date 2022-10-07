package com.book;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.author.Model.Book;
import com.author.repository.IBookRepository;
import com.author.service.BookServiceImpl;

@SpringBootTest(classes= {BookServiceTest.class})
public class BookServiceTest {
	
	@Mock
	IBookRepository bookrep;
	
	@InjectMocks
	BookServiceImpl bookService;
	
	@Test
	public void test_getBooksByTitle(String title)
	{
		List<Book> findByQueryMethod=new ArrayList<Book>();
		findByQueryMethod.add(new Book());
		
		when(bookrep.findByQueryMethod(title)).thenReturn(findByQueryMethod);
		assertEquals(1,bookService.getBooksByTitle(title));
	}

}
