package com.example.challenge.service.user.impl;

import com.example.challenge.model.User;
import com.example.challenge.repository.UserRepository;
import com.example.challenge.service.user.UpdateUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class UpdateUserServiceImpl implements UpdateUserService {
    private final UserRepository userRepository;
    public UpdateUserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public ResponseEntity<User> run(Model model) {
        return userRepository.findById(model.id).map(existing -> {
            existing.setName(model.user.getName());
            existing.setEmail(model.user.getEmail());
            if (model.user.getPassword() != null && !model.user.getPassword().isEmpty()) {
                existing.setPassword(model.user.getPassword());
            }
            User saved = userRepository.save(existing);
            saved.setPassword(null);
            return ResponseEntity.ok(saved);
        }).orElse(ResponseEntity.notFound().build());
    }
}
