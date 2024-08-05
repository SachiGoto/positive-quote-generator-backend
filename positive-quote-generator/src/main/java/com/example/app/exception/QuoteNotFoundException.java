package com.example.app.exception;

public class QuoteNotFoundException extends RuntimeException {
	
	   public QuoteNotFoundException(String message) {
	        super(message);
	    }
}
