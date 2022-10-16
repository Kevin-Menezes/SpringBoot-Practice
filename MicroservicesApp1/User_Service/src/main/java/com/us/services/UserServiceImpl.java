package com.us.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.us.entities.User;

@Service
public class UserServiceImpl implements UserService{

	List<User> list = List.of(
			new User(1001L,"KEVIN","9428573212"),
			new User(1002L,"KEENAN","9426346436"),
			new User(1003L,"MESSI","9428543754")
			
			);
	
	
	@Override
	public User getUser(Long id) {

		return list.stream().filter(user -> user.getUserId().equals(id)).findAny().orElse(null);
	}

}
