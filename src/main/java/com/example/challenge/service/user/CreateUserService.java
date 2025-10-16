package com.example.challenge.service.user;

import com.example.challenge.model.User;
import org.springframework.http.ResponseEntity;

public interface CreateUserService {

    public ResponseEntity<User> run (User user);
}
