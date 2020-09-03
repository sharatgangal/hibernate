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




	public Book addBook(Book book) {
		Session session=sessionFactory.getCurrentSession();
		session.save(book);
		return book;
	}




	/*@Override
	public boolean deleteBook(int bookId) {
		Session session=sessionFactory.getCurrentSession();
		boolean deleted=false;
		Book toBeDeleted=getBookById(bookId);
		if(toBeDeleted!=null)
		{
		session.delete(toBeDeleted);
		deleted=true;
		}
         return deleted;
	} */

	
	
	public Book getBookById(int bookId)
	{
		Session session=sessionFactory.getCurrentSession();
		Book book=session.get(Book.class,bookId);
	    return book;
	}


	public boolean deleteBook(int bookId) {
		Session session=sessionFactory.getCurrentSession();
		Book toBeDeleted=getBookById(bookId);
		session.delete(toBeDeleted);
		return true;
				
	}
	
	public boolean updateBook(int bookId, Book book){
		Session session=sessionFactory.getCurrentSession();
	   	Book toBeUpdated=getBookById(bookId);
	    session.clear();	
		session.update(book);
		return true;
	} 
	

	/*@Override
	public boolean updateBook(int bookId, Book book) {
		Session session=sessionFactory.getCurrentSession();
	    boolean updated=false;
		Book toBeUpdated=getBookById(bookId);
		if(toBeUpdated!=null)
		{ 
	    session.clear();	
		session.update(book);
		updated=true;
		}
		return updated;
	} */
	
	
}
