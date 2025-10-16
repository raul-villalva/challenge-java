package com.example.challenge.service.auth;

import com.example.challenge.model.User;

import org.springframework.http.ResponseEntity;


public interface RegisterAuthService {

    public ResponseEntity<?> run(User user);
}
