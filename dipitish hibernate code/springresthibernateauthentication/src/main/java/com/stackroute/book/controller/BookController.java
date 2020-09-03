package com.stackroute.book.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.book.exception.BookNotFoundException;
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


  /*  @PostMapping("/addBook")
	public Book addBook(@RequestBody Book book )
	{
        Book bookAdded=bookService.addBook(book);
        return bookAdded;
	} */
    
   /* @PostMapping("/addBook")
  	public ResponseEntity<?> addBook(@RequestBody Book book )
  	{
          Book bookAdded=bookService.addBook(book);
          return new ResponseEntity<Book>(bookAdded,HttpStatus.CREATED);
  	} */
    
    @PostMapping("/addBook")
  	public ResponseEntity<?> addBook(@RequestBody Book book,HttpSession session )
  	
  	{
    	if(session.getAttribute("userDetails")!=null)
    	{
          bookService.addBook(book);
          return new ResponseEntity<String>("Book created!!!",HttpStatus.CREATED);
    	}
       return new ResponseEntity<String>("UnAuthorized user!!!",HttpStatus.UNAUTHORIZED);
    } 
    
    // http://localhost:8080/springresthibernate/deleteBook/2
    
  /*  @DeleteMapping("/deleteBook/{bookId}")
    public ResponseEntity<?> deleteBook(@PathVariable int bookId)
    {
      if(bookService.deleteBook(bookId))
      {
    	  return new ResponseEntity<String>("Book deleted!!!",HttpStatus.OK);
      }
      return new ResponseEntity<String>("Book not found!!!",HttpStatus.NOT_FOUND);
    }
    
 // http://localhost:8080/springresthibernate/updateBook/3
    
  @PutMapping("/updateBook/{bookId}")
  public ResponseEntity<?> updateBook(@PathVariable int bookId, @RequestBody Book book)
  {
     if(bookService.updateBook(bookId, book))
     {
    	 return new ResponseEntity<String>("Book Updated!!!",HttpStatus.OK);
     }
     return new ResponseEntity<String>("Book not found!!!",HttpStatus.NOT_FOUND);
  } */

    // http://localhost:8080/springresthibernate/deleteBook/2
    
    @DeleteMapping("/deleteBook/{bookId}")
    public ResponseEntity<?> deleteBook(@PathVariable int bookId)
    {
      try {
		if(bookService.deleteBook(bookId))
		  {
			  return new ResponseEntity<String>("Book deleted!!!",HttpStatus.OK);
		  }
	
      } catch (BookNotFoundException e) {
				 return new ResponseEntity<String>("Book Not Found!!!",HttpStatus.NOT_FOUND);
	}
      return new ResponseEntity<String>("Success with delete!!!",HttpStatus.OK);
    }
    
 // http://localhost:8080/springresthibernate/updateBook/3
    
  @PutMapping("/updateBook/{bookId}")
  public ResponseEntity<?> updateBook(@PathVariable int bookId, @RequestBody Book book)
  {
     try {
		if(bookService.updateBook(bookId, book))
		 {
			 return new ResponseEntity<String>("Book Updated!!!",HttpStatus.OK);
		 }
	} catch (BookNotFoundException e) {
		 return new ResponseEntity<String>("Book Not Found!!!",HttpStatus.NOT_FOUND);
	}
     return new ResponseEntity<String>("Success with update!!!",HttpStatus.OK);
  } 
    
    
}