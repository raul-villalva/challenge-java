package com.example.challenge.service.posts.impl;

import com.example.challenge.model.Post;
import com.example.challenge.model.User;
import com.example.challenge.repository.PostRepository;
import com.example.challenge.repository.UserRepository;
import com.example.challenge.service.posts.CreatePostService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CreatePostServiceImpl implements CreatePostService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Post run(Long userId, Post post) {
        Optional<User> userOpt = userRepository.findById(userId);
        if(userOpt.isEmpty()) {
            throw new RuntimeException("Usuario no encontrado");
        }
        post.setUser(userOpt.get());
        return postRepository.save(post);
    }
}
