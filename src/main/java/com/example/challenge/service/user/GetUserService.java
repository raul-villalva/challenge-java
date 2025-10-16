package com.example.challenge.service.user;

import com.example.challenge.model.User;
import org.springframework.http.ResponseEntity;

public interface GetUserService {

    public class Model {

        public Model( Long id) {
            this.id = id;
        }
        public Long id;
    }

    public ResponseEntity<User> run (GetUserService.Model model);
}
