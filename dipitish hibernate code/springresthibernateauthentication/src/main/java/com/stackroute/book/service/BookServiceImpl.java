package com.stackroute.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.book.dao.BookDAO;
import com.stackroute.book.exception.BookNotFoundException;
import com.stackroute.book.model.Book;


@Service
public class BookServiceImpl implements BookService {

	private BookDAO bookDAO;
	
	@Autowired
	public BookServiceImpl(BookDAO bookDAO) {
		super();
		this.bookDAO = bookDAO;
	}


	
	public Book addBook(Book book) {
		// TODO Auto-generated method stub
		return bookDAO.addBook(book);
	}


	/*@Override
	public boolean deleteBook(int bookId) {
		// TODO Auto-generated method stub
		return bookDAO.deleteBook(bookId);
	}


	@Override
	public boolean updateBook(int bookId, Book book) {
		// TODO Auto-generated method stub
		return bookDAO.updateBook(bookId,book);
	} */

	
	public boolean deleteBook(int bookId) throws BookNotFoundException {
		if(bookDAO.getBookById(bookId)==null)
		{
			throw new BookNotFoundException("Book not found");
		}
		return bookDAO.deleteBook(bookId);
	}

	public boolean updateBook(int bookId, Book book) throws BookNotFoundException {
		if(bookDAO.getBookById(bookId)==null)
		{
			throw new BookNotFoundException("Book not found");
		}
		return bookDAO.updateBook(bookId, book);
	} 

	
	
}
