package com.pma.afford.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pma.afford.entities.User;
import com.pma.afford.repositories.UserRepository;

@Service
public class UserServiceImplementation implements UserService{

	@Autowired
	UserRepository userRepo;

	@Override
	public void saveNewUser(User user) {
		userRepo.save(user);
	}

	//for learning
	@Override
	public User getUserDetailsById(long Id) {
		return userRepo.findById(Id).get();
	}
}
