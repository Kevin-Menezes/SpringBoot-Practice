package com.cs.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cs.entities.Contact;

@Service
public class ContactServiceImpl implements ContactService{
	
	List<Contact> list = List.of(
			new Contact(1L,"Roh@gmail.com","Rohit",1001L),
			new Contact(2L,"Koh@gmail.com","Kohli",1001L),
			new Contact(3L,"Sky@gmail.com","Sky",1002L)
			);
	
	
	@Override
	public List<Contact> getContactsOfUsers(Long userId) {
		
		return list.stream().filter(contact -> contact.getUserId().equals(userId)).collect(Collectors.toList());
	}

}
