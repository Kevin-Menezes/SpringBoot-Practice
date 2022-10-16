package com.us.entities;

public class Contact {

	private Long id;
	private String email;
	private String contactName;
	private Long userId;
	
	// Default constructor
	public Contact() {
		super();
	}

	public Contact(Long id, String email, String contactName, Long userId) {
		super();
		this.id = id;
		this.email = email;
		this.contactName = contactName;
		this.userId = userId;
	}
	
	
}
