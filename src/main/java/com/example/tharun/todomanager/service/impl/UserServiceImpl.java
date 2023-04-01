package com.example.tharun.todomanager.service.impl;

import org.springframework.stereotype.Service;

import com.example.tharun.todomanager.entity.User;
import com.example.tharun.todomanager.repository.UserRepository;
import com.example.tharun.todomanager.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	
	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}


	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}


	@Override
	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}


	@Override
	public User findUserByPassword(String pass) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(pass);
	}




}
