package com.example.tharun.todomanager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.tharun.todomanager.entity.CustomUserDetails;
import com.example.tharun.todomanager.entity.User;
import com.example.tharun.todomanager.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	

	public CustomUserDetailsService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}



	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		 User user = userRepository.findByEmail(email);

	        if (user != null) {
	            return new CustomUserDetails(user);
	                   
	        }else{
	            throw new UsernameNotFoundException("Invalid username or password.");
	        }
	}

}
