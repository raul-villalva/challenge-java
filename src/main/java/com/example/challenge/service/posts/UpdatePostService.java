package com.example.challenge.service.posts;

import com.example.challenge.model.Post;

public interface UpdatePostService {

    public Post run(Long postId, Post postRequest);
}
