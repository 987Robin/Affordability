package com.pma.afford.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pma.afford.entities.LoginUser;
import com.pma.afford.entities.User;
import com.pma.afford.repositories.UserRepository;

@Service
public class UserServiceImplementation implements UserService{

	@Autowired
	UserRepository userRepo;
	
	@Autowired
    private PasswordEncoder passwordEncoder;

	@Override
	public String saveNewUser(User user) {
		
		if(userRepo.existsByUserMail(user.getUserMail())) {
			return "User already existes";
		} else {
			user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
			userRepo.save(user);
			return "User Saved succesfully";
		}
	}

	@Override
	public String authLoginUser(LoginUser loginUser) {
		return "Login Succesful";
	}
}
