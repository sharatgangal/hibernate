package com.stackroute.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.book.model.User;
import com.stackroute.book.service.UserService;


@RestController
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	
	
	 //  http://localhost:8080/springresthibernate/addUser
	  // Add user
	 @PostMapping("/addUser")
	   public  ResponseEntity<?>  addUser(@RequestBody User user) {
		boolean isAdded=userService.addUser(user);
		if(isAdded)
		{
			return new ResponseEntity<String>("Added!!",HttpStatus.OK);
		}
		return new ResponseEntity<String>("Not added!!",HttpStatus.CONFLICT);
	}                 
	
	
	
	
	/* Update user 
	    http://localhost:8080/springresthibernate/updateUser/1
		
	 @PutMapping("/updateUser/{userId}")
	   public void updateUser(@PathVariable int userId, @RequestBody User user)
	   {}
	*/

	
	
	/* Delete user
	 *   http://localhost:8080/springresthibernate/updateUser/1 
	 *   @DeleteMapping("/deleteUser/{userId}")
	 *   public void deleteUser(@PathVariable int userId) {}
	 */
	 
	
	
}
