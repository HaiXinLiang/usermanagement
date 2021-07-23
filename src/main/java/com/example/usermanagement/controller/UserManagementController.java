package com.example.usermanagement.controller;

import com.example.usermanagement.service.User;
import com.example.usermanagement.service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserManagementController {

    @Autowired
    private UserManagementService userService;

    @PostMapping("/api/user-management/user")
    @ResponseStatus(HttpStatus.CREATED)
    public void addNewUser(@RequestBody User user) {
        userService.addNewUser(user);
    }
}
