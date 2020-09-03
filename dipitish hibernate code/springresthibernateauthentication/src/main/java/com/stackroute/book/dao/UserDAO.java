package com.stackroute.book.dao;

import com.stackroute.book.model.User;

public interface UserDAO {

	boolean addUser(User user);

	boolean validateUser(int id, String password);
}
