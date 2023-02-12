package com.pma.afford.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	@PostMapping("/check1")
	public String printCheck1() {
		return "Check1";
	}
	
	@GetMapping("/check2")
	public String printCheck2() {
		return "Check2";
	}
	
	@GetMapping("/check3")
	public String printCheck3() {
		return "Check3";
	}
}
