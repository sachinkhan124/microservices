package com.example.app.dto;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
	private String message;
	private boolean sucess;
	private HttpStatus status;

}
