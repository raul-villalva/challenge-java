package com.example.challenge.service.user.impl;

import com.example.challenge.model.User;
import com.example.challenge.repository.UserRepository;
import com.example.challenge.service.user.ListUserService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListUserServiceImpl implements ListUserService {
    private final UserRepository userRepository;
    public ListUserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<User> run() {
        return userRepository.findAll();
    }
}
