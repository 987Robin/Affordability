package com.pma.afford.services;

import com.pma.afford.entities.User;
import org.springframework.security.core.Authentication;

public interface UserService {

    String saveNewUser(User user);

    String generateToken(Authentication authentication);
}
