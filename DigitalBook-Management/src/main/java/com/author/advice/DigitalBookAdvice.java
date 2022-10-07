package com.author.advice;

import java.sql.SQLException;
import java.util.Date;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.author.exception.AuthorNotFoundException;
import com.author.exception.BookNotFoundException;
import com.author.exception.CustomExceptionResponse;



@ControllerAdvice
public class DigitalBookAdvice {

	@ExceptionHandler(AuthorNotFoundException.class)
	public final ResponseEntity<CustomExceptionResponse> handleAuthorNotFound(Exception e, WebRequest ex) {
		CustomExceptionResponse exceptionResponse = new CustomExceptionResponse(new Date(), 500, e.getMessage(),
				"Server Error : Author Not Found Exception ", ex.getDescription(false), e);
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BookNotFoundException.class)
	public final ResponseEntity<CustomExceptionResponse> handleBookNotFound(Exception e, WebRequest ex) {
		CustomExceptionResponse exceptionResponse = new CustomExceptionResponse(new Date(), 500, e.getMessage(),
				"Server Error : Author Not Found Exception ", ex.getDescription(false), e);
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(SQLException.class)
	public final ResponseEntity<CustomExceptionResponse> handleSqlException(Exception e, WebRequest ex) {
		CustomExceptionResponse exceptionResponse = new CustomExceptionResponse(new Date(), 500, e.getMessage(),
				"Server Error : SQL Exception ", ex.getDescription(false), e);
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(NullPointerException.class)
	public final ResponseEntity<CustomExceptionResponse> handlNullPointerException(Exception e, WebRequest ex) {
		CustomExceptionResponse exceptionResponse = new CustomExceptionResponse(new Date(), 500, e.getMessage(),
				"Server Error : Null Pointer Exception ", ex.getDescription(false), e);
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(NoSuchElementException.class)
	public final ResponseEntity<CustomExceptionResponse> handleNoSuchelementException(Exception e, WebRequest ex) {
		CustomExceptionResponse exceptionResponse = new CustomExceptionResponse(new Date(), 500, e.getMessage(),
				"Server Error :No Such Element Found Exception ", ex.getDescription(false), e);
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
}
