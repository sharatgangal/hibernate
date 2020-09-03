package com.stackroute.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.book.model.Book;
import com.stackroute.book.service.BookService;

@RestController
public class BookController {

	
	private BookService bookService;
	
	
    @Autowired
	public BookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}


    @PostMapping("/addBook")
	public Book addBook(@RequestBody Book book )
	{
        Book bookAdded=bookService.addBook(book);
        return bookAdded;
	}
}
