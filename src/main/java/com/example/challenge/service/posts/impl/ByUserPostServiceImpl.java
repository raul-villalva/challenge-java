package com.example.challenge.service.posts.impl;

import com.example.challenge.model.Post;
import com.example.challenge.repository.PostRepository;
import com.example.challenge.service.posts.ByUserPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ByUserPostServiceImpl implements ByUserPostService {

    @Autowired
    private PostRepository postRepository;


    public List<Post> run(Long userId) {
        return postRepository.findByUserId(userId);
    }



}
