package com.example.usermanagement.service;

import com.example.usermanagement.repository.UserRepository;
import com.example.usermanagement.service.bean.UserOut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;

@Service
public class UserManagementService {

    Logger logger = LoggerFactory.getLogger(UserManagementService.class);

    final static String STATUS_ACTIVE = "Active";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Generator generator;

    @Autowired
    private CustomPage<User> customPage;

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

    public void deleteUserByEmail(String email) {
        if (userRepository.findById(email).isPresent())
            userRepository.deleteById(email);
        else return;
    }

    public void updateUser(User user) {
        if (userRepository.findById(user.getEmail()).isPresent()) {
            var dbUser = userRepository.findById(user.getEmail()).get();
            user.setUsername(user.getEmail());
            user.setAge(dbUser.getAge());
            user.setGender(dbUser.getGender());
            user.setNationality(dbUser.getNationality());
            user.setStatus(dbUser.getStatus());
            user.setCreated(dbUser.getCreated());
            user.setUpdated(LocalDateTime.now());
            userRepository.save(user);
        } else
            throw new EntityNotFoundException("User email: " + user.getEmail() + " cannot be found in the database");
    }

    public UserOut getUser(String email) {
        var dbUser = userRepository.findById(email).get();
        var userOut = new UserOut(
                dbUser.getPassword(),
                dbUser.getFirstName(),
                dbUser.getLastName(),
                dbUser.getEmail(),
                dbUser.getContactNumber(),
                dbUser.getAge(),
                dbUser.getGender(),
                dbUser.getNationality(),
                dbUser.getTags());
        return userOut;
    }

    public CustomPage<User> findPaginated(int pageNo, int pageSize){
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return new CustomPage<User>(userRepository.findAll(pageable));
    }
}
