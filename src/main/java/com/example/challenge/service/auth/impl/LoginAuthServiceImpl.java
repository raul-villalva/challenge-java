package com.example.challenge.service.auth.impl;

import com.example.challenge.repository.UserRepository;
import com.example.challenge.security.JwtUtil;
import com.example.challenge.service.auth.LoginAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import java.util.Map;
@Component
public class LoginAuthServiceImpl implements LoginAuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public ResponseEntity<?> run( Map<String, String> body) {
        String email = body.get("email");
        String password = body.get("password");
        try {
            // authManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
            String token = jwtUtil.generateToken(email);
            return ResponseEntity.ok(Map.of("token", token));
        } catch (Exception ex) {
            return ResponseEntity.status(401).body(Map.of("error", "Invalid credentials"));
        }
    }
}
