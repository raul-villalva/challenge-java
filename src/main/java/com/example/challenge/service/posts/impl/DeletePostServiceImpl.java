package com.example.challenge.service.posts.impl;

import com.example.challenge.repository.PostRepository;
import com.example.challenge.service.posts.DeletePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletePostServiceImpl implements DeletePostService  {

    @Autowired
    private PostRepository postRepository;

    public void run(Long postId) {
        postRepository.deleteById(postId);
    }
}
