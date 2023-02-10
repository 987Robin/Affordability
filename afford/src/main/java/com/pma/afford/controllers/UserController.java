package com.pma.afford.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pma.afford.entities.LoginUser;
import com.pma.afford.entities.User;
import com.pma.afford.services.UserService;

@RestController
@RequestMapping("/afford")
public class UserController {

	@Autowired
	UserService userService;
	
	

	@PostMapping("/signup")
	public String saveUser(@RequestBody User user) {
		
		return userService.saveNewUser(user);
	}
	
	@PostMapping("/signin")
	public String loginUserDetails(@RequestBody LoginUser loginUser) {
		return userService.authLoginUser(loginUser);
	}
}
