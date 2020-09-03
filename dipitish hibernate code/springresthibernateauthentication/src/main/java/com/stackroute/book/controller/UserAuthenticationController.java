package com.stackroute.book.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.book.model.User;
import com.stackroute.book.service.UserService;



// To validate that user is available
@RestController
public class UserAuthenticationController {

	private UserService userService;

	@Autowired
	public UserAuthenticationController(UserService userService) {
		super();
		this.userService = userService;
	}

		// http://localhost:8080/springresthibernate/login
	// Just check whether user is available
	 @PostMapping("/login")
public ResponseEntity<?> userLogin(@RequestBody User user,HttpSession session)
	{
		 // Check for whether the user  is existing or not
		 // if user is existing user , associate the user details( specifically the userId/userName) with session object
		  if(userService.validateUser(user.getId(),user.getPassword()))
		  {
		    session.setAttribute("userDetails",user.getId());
		    return new ResponseEntity<String>("Login Successful!!!!",HttpStatus.OK);
		  }
		 
		 return new ResponseEntity<String>("Login Failure",HttpStatus.UNAUTHORIZED);
		
	} 
	
	  // This handler method is to logout from the session
	 @GetMapping("/logout")
	 public ResponseEntity<?> logout(HttpSession session)
	 {
		 if(session.getAttribute("userDetails")!=null)
		 {
			 session.invalidate(); // With session.invalidate the associated attributes are lost
			 return new ResponseEntity<String>("Logged Out",HttpStatus.OK);
		 }
		 else
		 {
			 return new ResponseEntity<String>("User didn't logged in",HttpStatus.BAD_REQUEST);
		 }
	 }
	
}
