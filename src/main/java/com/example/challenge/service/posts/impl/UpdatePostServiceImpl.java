package com.example.challenge.service.posts.impl;

import com.example.challenge.model.Post;
import com.example.challenge.repository.PostRepository;
import com.example.challenge.service.posts.UpdatePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdatePostServiceImpl implements UpdatePostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Post run(Long postId, Post postRequest) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post no encontrado con id: " + postId));
        post.setTitle(postRequest.getTitle());
        post.setBody(postRequest.getBody());
        return postRepository.save(post);
    }


}
