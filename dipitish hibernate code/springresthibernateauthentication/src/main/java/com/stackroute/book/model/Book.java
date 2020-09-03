package com.stackroute.book.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/*
 *    This is a class whose object we are planning to persist and read as a resource
 */
@Entity

public class Book {
@Id
@GeneratedValue
private int id;
private String bookName;
private String author;



public Book() {
	super();
	// TODO Auto-generated constructor stub
}
public Book(int id, String bookName, String author) {
	super();
	this.id = id;
	this.bookName = bookName;
	this.author = author;
}



@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((author == null) ? 0 : author.hashCode());
	result = prime * result + ((bookName == null) ? 0 : bookName.hashCode());
	result = prime * result + id;
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Book other = (Book) obj;
	if (author == null) {
		if (other.author != null)
			return false;
	} else if (!author.equals(other.author))
		return false;
	if (bookName == null) {
		if (other.bookName != null)
			return false;
	} else if (!bookName.equals(other.bookName))
		return false;
	if (id != other.id)
		return false;
	return true;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getBookName() {
	return bookName;
}
public void setBookName(String bookName) {
	this.bookName = bookName;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
@Override
public String toString() {
	return "Book [id=" + id + ", bookName=" + bookName + ", author=" + author + "]";
}




}
