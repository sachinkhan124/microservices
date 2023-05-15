package com.example.app.service;

import java.util.List;

import com.example.app.entity.User;

public interface UserService {
	
	User createUser(User user);
	
	List<User>getAllUser();
	
	User getById(String userId);
	
	
}
