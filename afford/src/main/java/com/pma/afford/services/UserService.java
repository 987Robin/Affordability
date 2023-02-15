package com.pma.afford.services;

import com.pma.afford.entities.UserEntity;
import org.springframework.security.core.Authentication;

public interface UserService {

    String saveNewUser(UserEntity user);

    String generateToken(Authentication authentication);
}
