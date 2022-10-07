package com.author.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.*;

import com.author.dto.BookContentDto;
import com.author.dto.BookPaymentDto;
import com.author.dto.BookReaderDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


import java.util.Date;
import java.util.List;

import javax.persistence.JoinColumn;


@NamedNativeQuery(name = "Book.findBooksDtoByEmail_Named",
query = "SELECT b.category as category, b.author_name as authorName , b.title as title ,b.logo as logo ,b.active as active , b.price as price , b.publisher_name as publisherName , b.published_date as publishedDate  FROM Book b inner join  Reader r  on r.b_id = b.b_id where r.email=?1",
resultSetMapping = "Mapping.BookReaderDto")
@SqlResultSetMapping(name = "Mapping.BookReaderDto",classes = @ConstructorResult(targetClass = BookReaderDto.class,
                                columns = {@ColumnResult(name = "category"),
                                           @ColumnResult(name = "authorName"),
                                           @ColumnResult(name = "title"),
                                           @ColumnResult(name = "logo"),
                                           @ColumnResult(name = "active"),
                                           @ColumnResult(name = "price"),
                                           @ColumnResult(name = "publisherName"),
                                           @ColumnResult(name = "publishedDate")}))

@NamedNativeQuery(name = "Book.findBooksDtoByBookId_Names",
query = "SELECT b.category  as category FROM Book b inner join  Reader r  on r.b_id = b.b_id where r.email=?1 and r.b_id =?2",
resultSetMapping = "Mapping.BookContentDto")
@SqlResultSetMapping(name = "Mapping.BookContentDto",classes = @ConstructorResult(targetClass = BookContentDto.class,
                                columns = {@ColumnResult(name = "category") }))
   


@NamedNativeQuery(name = "Book.findBookDtoByPayId_Named",
query = "SELECT b.category as category, b.author_name as authorName , b.title as title ,b.logo as logo ,b.active as active , b.price as price , b.publisher_name as publisherName , b.published_date as publishedDate  FROM Book b inner join  Reader r  on r.b_id = b.b_id where r.email=?1 and r.pay_id=?2",
resultSetMapping = "Mapping.BookPaymentDto")
@SqlResultSetMapping(name = "Mapping.BookPaymentDto",classes = @ConstructorResult(targetClass = BookPaymentDto.class,
                                columns = {@ColumnResult(name = "category"),
                                           @ColumnResult(name = "authorName"),
                                           @ColumnResult(name = "title"),
                                           @ColumnResult(name = "logo"),
                                           @ColumnResult(name = "active"),
                                           @ColumnResult(name = "price"),
                                           @ColumnResult(name = "publisherName"),
                                           @ColumnResult(name = "publishedDate")}))

                        
@Entity
public class Book  {



	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer bId;

	private String logo;
	
	private String title;
	
	private String category;
	
	private double price;
	
	private String publisherName;
	
	@Temporal(TemporalType.DATE)
	
	private Date publishedDate;
	
	private Integer chapters;
	private String active;
	
	private String authorName;
	@ManyToOne
	@JoinColumn(name="aId")
	@JsonBackReference
	private Author author;
	
	
	@OneToMany(mappedBy = "book")
	@JsonManagedReference
	private List<Reader> readers;
	
	public Book(Integer bId, Author author, String logo, String title, String category, double price,
			String publisherName, Date publishedDate, Integer chapters, String active, String authorName,
			List<Reader> readers) {
		super();
		this.bId = bId;
		this.author = author;
		this.logo = logo;
		this.title = title;
		this.category = category;
		this.price = price;
		this.publisherName = publisherName;
		this.publishedDate = publishedDate;
		this.chapters = chapters;
		this.active = active;
		this.authorName = authorName;
		this.reader = readers;
	}

	public List<Reader> getReader() {
		return reader;
	}

	public void setReader(List<Reader> reader) {
		this.reader = reader;
	}
	
	
	@OneToMany(mappedBy = "book")
	@JsonManagedReference
	private List<Reader> reader;

	
	public Book() {
		super();
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Integer getBId() {
		return bId;
	}
	public void setBId(Integer bId) {
		this.bId = bId;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	public Date getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}
	public Integer getChapters() {
		return chapters;
	}
	public void setChapters(Integer chapters) {
		this.chapters = chapters;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}

	public Book(String logo, String title, String category, double price, String publisherName, Date publishedDate,
			String active, String authorName) {
		super();
		this.logo = logo;
		this.title = title;
		this.category = category;
		this.price = price;
		this.publisherName = publisherName;
		this.publishedDate = publishedDate;
		this.active = active;
		this.authorName = authorName;
	}

	
	
	
}

