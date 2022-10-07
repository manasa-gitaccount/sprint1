package com.author.exception;

public class AuthorNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public AuthorNotFoundException(){
        super();
    }
    public AuthorNotFoundException(String m){
        super(m);
    }
    public AuthorNotFoundException(Exception e){
        super(e);
    }
    public AuthorNotFoundException(String s, Exception e){
        super(s, e);
    }


}
