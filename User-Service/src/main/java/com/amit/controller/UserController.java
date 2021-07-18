package com.amit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.amit.entity.Contact;
import com.amit.entity.User;
import com.amit.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/{userId}")
	public User getUser(@PathVariable Long userId) {
		// localhost:9002/contact/user/123
		User user = this.userService.getUser(userId);
		List<Contact> contacts = this.restTemplate.getForObject("http://contact-service/contact/user/" + user.getUserId(),
				List.class);
		user.setContacts(contacts);

		return user;
	}

}
