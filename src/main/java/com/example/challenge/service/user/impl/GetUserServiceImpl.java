package com.example.challenge.service.user.impl;

import com.example.challenge.model.User;
import com.example.challenge.repository.UserRepository;
import com.example.challenge.service.user.GetUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class GetUserServiceImpl implements GetUserService {
    private final UserRepository userRepository;
    public GetUserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public ResponseEntity<User> run(Model model) {
        return userRepository.findById(model.id)
                .map(u -> { u.setPassword(null); return ResponseEntity.ok(u); })
                .orElse(ResponseEntity.notFound().build());
    }
}
