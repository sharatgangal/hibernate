package com.stackroute.book.service;

import com.stackroute.book.exception.BookNotFoundException;
import com.stackroute.book.model.Book;

public interface BookService {

	Book addBook(Book book);

	boolean deleteBook(int bookId) throws BookNotFoundException;

	boolean updateBook(int bookId, Book book)  throws BookNotFoundException;
	
}
