package com.rest.api.exception;

public class BookNotFoundException extends Exception {

	private long book_id;
	
	public BookNotFoundException(long book_id) {
		super(String.format("Books is not found with id: '%s'", book_id));
	}
		
}
