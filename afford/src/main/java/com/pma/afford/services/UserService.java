package com.pma.afford.services;

import com.pma.afford.entities.LoginUser;
import com.pma.afford.entities.User;

public interface UserService {

	String saveNewUser(User user);

	String authLoginUser(LoginUser loginUser);

}
