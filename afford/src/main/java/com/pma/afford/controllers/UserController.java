package com.pma.afford.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pma.afford.entities.User;
import com.pma.afford.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/signUp")
	public String saveUser(@RequestBody User user) {
		userService.saveNewUser(user);
		
		return "Succesful";
	}
	
	@PostMapping("/getUser/{id}")
	public User getUserDetails(@PathVariable(name = "id") long userIdentity) {
		
		return userService.getUserDetailsById(userIdentity);
	}
}
