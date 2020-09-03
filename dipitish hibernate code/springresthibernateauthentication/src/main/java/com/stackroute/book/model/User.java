package com.stackroute.book.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
@Id
@GeneratedValue
private int id;
private String password;
private String mobileNumber;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getMobileNumber() {
	return mobileNumber;
}
public void setMobileNumber(String mobileNumber) {
	this.mobileNumber = mobileNumber;
}
@Override
public String toString() {
	return "User [id=" + id + ", password=" + password + ", mobileNumber=" + mobileNumber + "]";
}


}
