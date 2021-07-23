package com.example.usermanagement.service;

import com.example.usermanagement.repository.UserRepository;
import com.example.usermanagement.service.Generator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserManagementService {
    final static String STATUS_ACTIVE = "Active";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Generator generator;

    public void addNewUser(User user) {
        user.setUsername(user.getEmail());
        user.setAge(generator.getAgeByName(user.getFirstName()));
        user.setGender(generator.getGenderByName(user.getFirstName()));
        user.setNationality(generator.getNationalityByName(user.getFirstName()));
        user.setStatus(STATUS_ACTIVE);
        user.setCreated(LocalDateTime.now());
        user.setUpdated(LocalDateTime.now());
        userRepository.save(user);
    }
}
