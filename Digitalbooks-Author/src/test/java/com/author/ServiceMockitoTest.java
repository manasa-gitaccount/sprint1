package com.author;



import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.author.Model.Author;
import com.author.repository.AuthorRepository;
import com.author.service.AuthorServiceImpl;

@SpringBootTest(classes= {ServiceMockitoTest.class})
public class ServiceMockitoTest {

	@Mock
	AuthorRepository authorRep;
	
	@InjectMocks
	AuthorServiceImpl authorService;
	
	@Test
	@Order(1)
	public void test_addAuthor(Author author)
	{
		
		authorService.addAuthor(author);
	}
}
