package com.niit;

import javax.persistence.*;

@Entity
@Table(name="Book")

public class Book {
	@Id 
	@Column(name = "id")
	private int id;
	@Column(name = "bookname")
	private String bookname;
	@Column(name = "author")
	private String author;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
    
}
