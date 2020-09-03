package com.stackroute.book.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stackroute.book.model.User;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

	private SessionFactory sessionFactory;
	
	
	@Autowired
	public UserDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}



	
	public boolean addUser(User user) {
		Session session=sessionFactory.getCurrentSession();
		session.save(user);
		return true;
	}



	
	public boolean validateUser(int id, String password) {
		boolean validUser=false;
		Session session=sessionFactory.getCurrentSession();
		User user=session.get(User.class, id);
		if(user!=null)
		{
			if(user.getPassword().equalsIgnoreCase(password))
			{
				validUser=true;
			}
	}
		
		return validUser;
	}

}
