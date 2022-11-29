package com.sa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sa.config.CustomUserDetails;
import com.sa.entities.User;
import com.sa.repositories.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository urep;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = urep.findByUsername(username);
		
		// Checking if the user is not in the DB
		if (user == null) {
			throw new UsernameNotFoundException("User 404");
		}
	
		return new CustomUserDetails(user); // Here we needed to return a UserDetails object...but UserDetails is an interface so we can't create an object...hence we create our own custom class and implement the UserDetails class
	}
	
}
