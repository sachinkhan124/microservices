package com.example.HotelService.exception;

public class ResourceNotFoundException extends RuntimeException{

	private String message;

	public ResourceNotFoundException() {
		super("Resource Not found Exception");
		
	}

	public ResourceNotFoundException(String message) {
		super(message);
		
	}
	
}
