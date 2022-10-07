package com.author.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.author.Model.Book;
import com.author.dto.BookContentDto;
import com.author.dto.BookPaymentDto;
import com.author.dto.BookReaderDto;


@Repository
public interface IBookRepository extends JpaRepository<Book, Integer> {

	
	
	//@Query("select book.category,book.published_date,book.logo,book.author_name,book.publisher_name,book.active,book.price" ,nativeQuery=true)
	@Query("select b from Book b where b.publisherName=?1 and b.category=?2 and b.price=?3 and b.authorName=?4")
	List<Book> findByPublisherNameAndCategoryAndPriceAndAuthorName(String publisherName,String category, double price,String authorName);
	
	
	@Query("select b from Book b where b.title=?1")
	List<Book> findByQueryMethod(String title);
//select book.logo,book.author_name,book.published_date,book.publisher_name,book.price ,book.title from reader inner join book on reader.b_id=book.b_id where reader.email='sreeniRAVINDRA@gmail.com';
	
	
	@Query(value ="select book.a_id,book.chapters,book.category,book.published_date,book.b_id,book.logo,book.author_name,book.publisher_name,book.active,book.price,book.title from book  inner join reader  on book.b_id=reader.b_id where reader.email=?1" ,nativeQuery=true)
	  public List<Book> findBooksByEmail( @Param(value = "email") String email);
	
	@Query(value ="select book.category,book.published_date,book.logo,book.author_name,book.publisher_name,book.active,book.price,book.title from book  inner join reader  on book.b_id=reader.b_id where reader.email=?1" ,nativeQuery=true)
	public List<BookReaderDto> findTestTwo( @Param(value = "email") String email);
	
	
	
	
	
	//TEST
	
	@Query(nativeQuery = true)
   public List<BookReaderDto> findBooksDtoByEmail_Named(String  email);
	
	
	@Query(nativeQuery = true)
	public List<BookContentDto> findBooksDtoByBookId_Names(String email , Integer bId);
	
	
	@Query(nativeQuery=true)
	public List<BookPaymentDto> findBookDtoByPayId_Named(String email,Integer payId);
	
	
}
	



	

