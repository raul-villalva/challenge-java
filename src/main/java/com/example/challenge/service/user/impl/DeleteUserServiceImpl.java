package com.example.challenge.service.user.impl;

import com.example.challenge.repository.UserRepository;
import com.example.challenge.service.user.DeleteUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class DeleteUserServiceImpl implements DeleteUserService {

    private final UserRepository userRepository;
    public DeleteUserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<Void> run(Model model) {
        return userRepository.findById(model.id).map(u -> {
            userRepository.deleteById(model.id);
            return ResponseEntity.noContent().<Void>build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
