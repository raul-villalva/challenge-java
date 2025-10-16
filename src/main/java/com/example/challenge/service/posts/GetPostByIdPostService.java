package com.example.challenge.service.posts;

import org.springframework.http.ResponseEntity;

public interface GetPostByIdPostService {
    public ResponseEntity<?> run(Long postId);
}
