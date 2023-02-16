package com.pma.afford.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class UserRepositoryTest {

    @Autowired
    UserRepository userRepositoryTest;

    String userMail = "girisharan.pusuluru@gmail.com";

    @Test
    void checkFindByUserMail() {

    }

//    @Test
//    void checkExistsByUserMail() {
//        //given
//        UserEntity user = new UserEntity("giri sharan reddy", "pusuluru", userMail, "password", 9010823);
//        userRepositoryTest.save(user);
//
//        //when
//        Boolean userExists = userRepositoryTest.existsByUserMail(userMail);
//
//        //then
//        assertThat(userExists).isTrue();
//
//    }
}