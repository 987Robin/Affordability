package com.pma.afford.repositories;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.pma.afford.entities.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
	UserEntity findByUserMail(String username);
	Boolean existsByUserMail(String userMail);
}
