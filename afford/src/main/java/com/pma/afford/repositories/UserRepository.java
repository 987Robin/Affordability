package com.pma.afford.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pma.afford.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
