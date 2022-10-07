package com.author.exception;

public class BookNotFoundException extends Exception {
	
private static final long serialVersionUID = 1L;
	
	public BookNotFoundException(){
        super();
    }
    public BookNotFoundException(String m){
        super(m);
    }
    public BookNotFoundException(Exception e){
        super(e);
    }
    public BookNotFoundException(String s, Exception e){
        super(s, e);
    }


}
