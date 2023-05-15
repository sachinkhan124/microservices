package com.example.HotelService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.HotelService.dto.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse>resourceNothandlerException(ResourceNotFoundException ex)
	{
		String message=ex.getMessage();
		ApiResponse response=new ApiResponse(message,false);
		return new ResponseEntity<ApiResponse>(response,HttpStatus.OK);
	}

}
