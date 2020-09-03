package com.stackroute.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.book.dao.UserDAO;
import com.stackroute.book.model.User;

@Service
public class UserServiceImpl implements UserService {

 private UserDAO userDAO;
	
    @Autowired
	public UserServiceImpl(UserDAO userDAO) {
	super();
	this.userDAO = userDAO;
}


	
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		return userDAO.addUser(user);
	}


	
	public boolean validateUser(int id, String password) {
		// TODO Auto-generated method stub
		return userDAO.validateUser(id,password);
	}

}
