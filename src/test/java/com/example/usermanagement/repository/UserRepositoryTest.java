package com.example.usermanagement.repository;

import com.example.usermanagement.service.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;


    @Test
    public void testSaveUser(){
        var user = getUser();
        var userInDb = entityManager.persist(user);
        assertNotNull(userInDb);
    }

    private User getUser() {
        var user = new User();
        user.setEmail("123@gmail.com");
        user.setUsername(user.getEmail());
        user.setFirstName("first");
        user.setLastName("last");
        user.setContactNumber("238237");
        user.setStatus("Active");
        user.setTags(new String[]{"a","b"});
        user.setCreated(LocalDateTime.now());
        user.setUpdated(LocalDateTime.now());
        user.setNationality("TH");
        user.setGender("male");
        user.setAge(34);

        return user;
    }

}