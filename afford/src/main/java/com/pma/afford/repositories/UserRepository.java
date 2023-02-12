package com.pma.afford.repositories;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.pma.afford.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {
	Optional<User> findByUserMail(String username);
	Boolean existsByUserMail(String userMail);
}
