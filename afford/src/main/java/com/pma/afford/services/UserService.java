package com.pma.afford.services;

import com.pma.afford.entities.User;

public interface UserService {

	void saveNewUser(User user);

	// for learning
	User getUserDetailsById(long Id);

}
