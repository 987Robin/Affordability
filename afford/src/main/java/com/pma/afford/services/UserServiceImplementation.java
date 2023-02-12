package com.pma.afford.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pma.afford.entities.User;
import com.pma.afford.entities.UserDetailsClass;
import com.pma.afford.repositories.UserRepository;

@Service
public class UserServiceImplementation implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	private final PasswordEncoder passwordEncoder;

	@Autowired
	public UserServiceImplementation(PasswordEncoder passwordEncoder) {
	    this.passwordEncoder = passwordEncoder;
	}

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
}
