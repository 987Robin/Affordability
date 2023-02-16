package com.pma.afford.repositories;


import org.springframework.data.repository.CrudRepository;

import com.pma.afford.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUserMail(String username);
	Boolean existsByUserMail(String userMail);
}
