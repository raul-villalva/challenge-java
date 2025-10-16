package com.example.challenge.service.auth;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface LoginAuthService {

    public ResponseEntity<?> run( Map<String, String> body);
}
