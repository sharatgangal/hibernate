package com.stackroute.book.dao;

import com.stackroute.book.model.Book;

public interface BookDAO {

	Book addBook(Book book);

	boolean deleteBook(int bookId);

	boolean updateBook(int bookId, Book book);
	
	public Book getBookById(int bookId);
}
