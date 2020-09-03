package com.stackroute.book.service;

import com.stackroute.book.model.User;

public interface UserService {

	
	boolean addUser(User user);

	boolean validateUser(int id, String password);
	
}
