package com.example.challenge.service.auth.impl;

import com.example.challenge.model.User;
import com.example.challenge.repository.UserRepository;
import com.example.challenge.service.auth.RegisterAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class RegisterAuthServiceImpl implements RegisterAuthService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseEntity<?> run(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Email already in use"));
        }
        User saved = userRepository.save(user);
        Map<String,Object> res = new HashMap<>();
        res.put("id", saved.getId());
        res.put("email", saved.getEmail());
        return ResponseEntity.ok(res);
    }

}
