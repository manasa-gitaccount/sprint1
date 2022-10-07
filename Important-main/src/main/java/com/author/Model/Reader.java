package com.author.Model;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity 
public class Reader {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer rId;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="bId")
	@JsonBackReference
	private Book book;
	
	
	private String name;
	
	private String email;
	
	@CreationTimestamp
	private Date purchaseTime;
	

	private Integer payId;

	public Reader() {
		super();
	}

	public Integer getrId() {
		return rId;
	}

	public void setrId(Integer rId) {
		this.rId = rId;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getPurchaseTime() {
		return purchaseTime;
	}

	public void setPurchaseTime(Date purchaseTime) {
		this.purchaseTime = purchaseTime;
	}

	public Integer getPayId() {
		return payId;
	}

	public void setPayId(Integer payId) {
		this.payId = payId;
	}

	public Reader(Integer rId, Book book, String name, String email, Date purchaseTime, Integer payId) {
		super();
		this.rId = rId;
		this.book = book;
		this.name = name;
		this.email = email;
		this.purchaseTime = purchaseTime;
		this.payId = payId;
	}

	@Override
	public String toString() {
		return "Reader [rId=" + rId + ", book=" + book + ", name=" + name + ", email=" + email + ", purchaseTime="
				+ purchaseTime + ", payId=" + payId + "]";
	}
	
	
	
	
}
