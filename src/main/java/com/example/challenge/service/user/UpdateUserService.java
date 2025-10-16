package com.example.challenge.service.user;

import com.example.challenge.model.User;
import org.springframework.http.ResponseEntity;

public interface UpdateUserService {

    public class Model {

        public Model( User user, Long id) {
            this.user = user;
            this.id = id;
        }
        public User user;
        public Long id;
    }

    public ResponseEntity<User> run (Model model);
}
