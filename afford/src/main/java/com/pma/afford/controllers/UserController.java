package com.pma.afford.controllers;

import com.pma.afford.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pma.afford.entities.UserEntity;
import com.pma.afford.services.UserServiceImpl;

import java.security.Principal;

@RestController
@RequestMapping("/afford")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/signup")
	public ResponseEntity<String> saveUser(@RequestBody UserEntity user) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveNewUser(user));
	}

	@PostMapping("/signin")
	public ResponseEntity<String> token(Authentication authentication, Principal principal) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.generateToken(authentication));
	}
	
	@GetMapping("/home")
	public String homePage() {
		return "<h1>Welcome to Home Page</h1>";
	}
}
