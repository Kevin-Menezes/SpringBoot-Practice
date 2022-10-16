package com.cs.entities;

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

	// Getter setter
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
