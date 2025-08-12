//package com.enciu.rohighwaypulse.service;
//
//import com.enciu.rohighwaypulse.module.User;
//import com.enciu.rohighwaypulse.repository.UserRepository;
//import com.enciu.rohighwaypulse.security.UserDetailsImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.web.server.ResponseStatusException;
//
//import java.util.Date;
//
////@Service
////public class UserService  implements UserDetailsService {
////    private final UserRepository userRepository;
////    private final BCryptPasswordEncoder passwordEncoder;
////
////    @Autowired
////    public UserService(BCryptPasswordEncoder passwordEncoder, UserRepository userRepository) {
////        this.passwordEncoder = passwordEncoder;
////        this.userRepository = userRepository;
////    }
////    @Override
////    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
////        User user = userRepository.findByEmail(email)
////                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
////
////        return new UserDetailsImpl(user);
////    }
////    public void register(User user) {
////        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
////            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already in use");
////        }
////
////        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
////            throw new ResponseStatusException(HttpStatus.CONFLICT, "Username already taken");
////        }
////
////        user.setPassword(passwordEncoder.encode(user.getPassword()));
////        user.setRole("USER");
////        user.setRegistrationDate(new Date());
////        userRepository.save(user);
////    }
////}
