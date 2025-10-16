package com.example.challenge.service.user;

import org.springframework.http.ResponseEntity;


public interface DeleteUserService {

    public class Model {

        public Model( Long id) {
            this.id = id;
        }
        public Long id;
    }

    public ResponseEntity<Void> run (Model model);
}
