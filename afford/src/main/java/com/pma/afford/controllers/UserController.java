package com.pma.afford.controllers;

import com.pma.afford.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pma.afford.entities.User;

@RestController
@RequestMapping("/afford")
public class UserController {

	@Autowired
	UserService userService;


	
	@PostMapping("/signup")
	public ResponseEntity<String> saveUser(@RequestBody User user) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveNewUser(user));
	}

	@GetMapping("/login")
	public String loginUser(Authentication authentication) {
		System.out.println(authentication.getName());
		String tokenGenerated = userService.generateToken(authentication);
		System.out.println("Generated Token:"+tokenGenerated);
		return tokenGenerated;
	}
	
	@GetMapping("/home")
	public ResponseEntity<String> homePage(Authentication authentication) {
		System.out.println(authentication.getName());
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.generateToken(authentication));
	}
}
