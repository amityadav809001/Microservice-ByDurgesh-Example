package com.amit.service;

import java.util.List;

import com.amit.entity.Contact;

public interface ContactService {
	
	public List<Contact> getContactOfUser(Long userId);

}
