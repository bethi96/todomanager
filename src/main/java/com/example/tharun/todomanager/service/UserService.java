package com.example.tharun.todomanager.service;

import org.springframework.data.jdbc.repository.query.Query;

import com.example.tharun.todomanager.entity.User;


public interface UserService   {
	
	User saveUser(User user);
	
	
	User findUserByEmail(String email);
	
	User findUserByPassword (String pass);
}
