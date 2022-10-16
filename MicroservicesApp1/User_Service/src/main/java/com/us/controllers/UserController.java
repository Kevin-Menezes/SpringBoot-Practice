package com.us.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.us.entities.Contact;
import com.us.entities.User;
import com.us.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService us;
	
	@Autowired
	private RestTemplate restTemplate; // This is to connect both the microservices together
	
	@GetMapping("/")
	public String demo() {
		return "Inside user";
	}

	@GetMapping("/{userId}")
	public User getUser(@PathVariable("userId") Long userId) {
		
		User user = this.us.getUser(userId);
		//List contact = this.restTemplate.getForObject("http://localhost:9002/contacts/users/"+userId, List.class);
		List contact = this.restTemplate.getForObject("http://contact-service/contact/user/"+userId, List.class);
		System.out.println("=============================User list with contacts -> "+contact);
		
		user.setContacts(contact); // Putting in the setter of contact
		
		return user;
	}
	
	
}
