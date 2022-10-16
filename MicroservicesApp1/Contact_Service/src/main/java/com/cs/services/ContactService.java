package com.cs.services;

import java.util.List;

import com.cs.entities.Contact;

public interface ContactService {
	
	public List<Contact> getContactsOfUsers(Long userId);

}
