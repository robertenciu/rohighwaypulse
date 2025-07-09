package com.enciu.rohighwaypulse.service;

import com.enciu.rohighwaypulse.module.User;
import com.enciu.rohighwaypulse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;

@Service
public class UserService {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    public void register(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already in use");
        }

        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Username already taken");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("USER");
        user.setRegistrationDate(new Date());
        userRepository.save(user);
    }
}
