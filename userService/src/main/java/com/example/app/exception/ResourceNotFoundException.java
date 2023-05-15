package com.example.app.exception;

public class ResourceNotFoundException extends RuntimeException{

	public ResourceNotFoundException() {
		super("resource Not Found on server!!");
		
	}

	

	public ResourceNotFoundException(String message) {
		super(message);
		
	}

	

	
}
