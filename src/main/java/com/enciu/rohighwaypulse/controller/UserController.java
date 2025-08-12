//package com.enciu.rohighwaypulse.controller;
//
//import com.enciu.rohighwaypulse.dto.LoginRequestDTO;
//import com.enciu.rohighwaypulse.module.User;
//import com.enciu.rohighwaypulse.repository.UserRepository;
//import com.enciu.rohighwaypulse.security.JwtUtil;
//import com.enciu.rohighwaypulse.security.UserDetailsImpl;
//import com.enciu.rohighwaypulse.service.UserService;
//import jakarta.servlet.http.HttpServletRequest;
//import org.apache.catalina.Authenticator;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.server.ResponseStatusException;
//
//import java.util.Collections;
//
//@RestController
//public class UserController {
////    private final AuthenticationManager authenticationManager;
////    private final UserService userService;
////    private final JwtUtil jwtUtil;
////    @Autowired
////    public UserController(AuthenticationManager authenticationManager, UserService userService, JwtUtil jwtUtil) {
////        this.authenticationManager = authenticationManager;
////        this.userService = userService;
////        this.jwtUtil = jwtUtil;
////    }
////    @PostMapping("/api/auth/register")
////    public ResponseEntity<String> register(@RequestBody User user) {
////        try {
////            userService.register(user);
////            System.out.println("user inregistrat");
////            return ResponseEntity.status(201).body("User registered successfully");
////        } catch (ResponseStatusException ex) {
////            return ResponseEntity.status(ex.getStatusCode()).body(ex.getReason());
////        }
////    }
////    @GetMapping("/api/auth/me")
////    public ResponseEntity<?> me(Authentication authentication) {
////        if (authentication == null || !authentication.isAuthenticated()) {
////            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Not authenticated");
////        }
////
////        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
////        return ResponseEntity.ok(userDetails);
////    }
////    @PostMapping("/api/auth/login")
////    public ResponseEntity<?> login(@RequestBody LoginRequestDTO request) {
////        try {
////            authenticationManager.authenticate(
////                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
////
////            UserDetails userDetails = userService.loadUserByUsername(request.getUsername());
////            String token = jwtUtil.generateToken(userDetails);
////
////            return ResponseEntity.ok(Collections.singletonMap("token", token));
////        } catch (AuthenticationException e) {
////            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
////        }
////    }
//}
