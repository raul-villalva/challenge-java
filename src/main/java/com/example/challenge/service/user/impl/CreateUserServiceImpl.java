package com.example.challenge.service.user.impl;

import com.example.challenge.model.User;
import com.example.challenge.repository.UserRepository;
import com.example.challenge.service.user.CreateUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.net.URI;

@Component
public class CreateUserServiceImpl implements CreateUserService {

    private final UserRepository userRepository;
    public CreateUserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public ResponseEntity<User> run(User user) {

        User saved = userRepository.save(user);
        saved.setPassword(user.getPassword());
        return ResponseEntity.created(URI.create("/api/users/" + saved.getId())).body(saved);
    }
}
