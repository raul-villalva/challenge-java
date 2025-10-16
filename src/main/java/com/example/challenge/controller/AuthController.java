package com.example.challenge.controller;

import com.example.challenge.model.User;

import com.example.challenge.service.auth.LoginAuthService;
import com.example.challenge.service.auth.RegisterAuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {


    private final RegisterAuthService registerAuthService;
    private final LoginAuthService loginAuthService;

    public AuthController(
                          RegisterAuthService registerAuthService,
                          LoginAuthService loginAuthService
                          ) {

        this.registerAuthService = registerAuthService;
        this.loginAuthService = loginAuthService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody User user) {
        return registerAuthService.run(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
        return loginAuthService.run(body);
    }
}
