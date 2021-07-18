package com.amit.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.amit.entity.Contact;

@Service
public class ContactServiceImpl implements ContactService {

	List<Contact> list = List.of(
			new Contact(1L, "amit@gmail.com", "Amit", 123L),
			new Contact(2L, "ayay@gmail.com", "ajay", 123L),
			new Contact(3L, "amit@gmail.com", "Amit", 124L), 
			new Contact(4L, "amit@gmail.com", "Amit", 125L));

	@Override
	public List<Contact> getContactOfUser(Long userId) {
		// TODO Auto-generated method stub
		return list.
				stream().
				filter(contact->contact.getUserId().equals(userId)).
				collect(Collectors.toList());
	}

}
