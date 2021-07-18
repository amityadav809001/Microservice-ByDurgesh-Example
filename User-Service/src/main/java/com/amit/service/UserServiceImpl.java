package com.amit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.amit.entity.User;

@Service
public class UserServiceImpl implements UserService {

	List<User> list = List.of(new User(123L, "amit yadav", "9947"), new User(124L, "anil", "99447"),
			new User(125L, "sameer yadav", "9933327"));

	@Override
	public User getUser(Long id) {
		// TODO Auto-generated method stub
		return list.stream().filter(user -> user.getUserId().equals(id)).findAny().orElse(null);
	}

}
