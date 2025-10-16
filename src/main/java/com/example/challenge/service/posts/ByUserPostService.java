package com.example.challenge.service.posts;

import com.example.challenge.model.Post;

import java.util.List;

public interface ByUserPostService {
    public List<Post> run(Long userId);
}
