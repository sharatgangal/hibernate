package com.stackroute.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.book.dao.BookDAO;
import com.stackroute.book.model.Book;


@Service
public class BookServiceImpl implements BookService {

	private BookDAO bookDAO;
	
	@Autowired
	public BookServiceImpl(BookDAO bookDAO) {
		super();
		this.bookDAO = bookDAO;
	}


	@Override
	public Book addBook(Book book) {
		// TODO Auto-generated method stub
		return bookDAO.addBook(book);
	}

}
