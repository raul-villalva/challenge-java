package com.example.challenge.service.posts;

import com.example.challenge.model.Post;

public interface CreatePostService {

    public Post run(Long userId, Post post);
}
