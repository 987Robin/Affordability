package com.pma.afford.services;

import java.util.Optional;

import com.pma.afford.entities.User;

public interface UserService {
	
	void saveNewUser(User user);
	
	User getUserDetailsById(long Id);

}
