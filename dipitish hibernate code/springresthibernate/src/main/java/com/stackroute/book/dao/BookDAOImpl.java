package com.stackroute.book.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stackroute.book.model.Book;

@Repository
@Transactional
public class BookDAOImpl implements BookDAO {
	
	
	private SessionFactory sessionFactory;
	
	
	
    @Autowired
	public BookDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}




	@Override
	public Book addBook(Book book) {
		Session session=sessionFactory.getCurrentSession();
		session.save(book);
		return book;
	}

}
