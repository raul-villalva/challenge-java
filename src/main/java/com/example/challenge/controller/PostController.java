package com.example.challenge.controller;

import com.example.challenge.model.Post;
import com.example.challenge.service.posts.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private GetPostByIdPostService getPostByIdPostService;
    @Autowired
    private CreatePostService createPostService;
    @Autowired
    private ByUserPostService byUserPostService;
    @Autowired
    private DeletePostService deletePostService;
    @Autowired
    private UpdatePostService updatePostService;

    @PostMapping("/{userId}")
    public ResponseEntity<Post> createPost(@PathVariable Long userId, @Validated @RequestBody Post post) {
        Post created = createPostService.run(userId, post);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Post>> getPostsByUser(@PathVariable Long userId) {
        List<Post> posts = byUserPostService.run(userId);
        return ResponseEntity.ok(posts);
    }
    

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable Long postId) {
        deletePostService.run(postId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{postId}")
    public ResponseEntity<Post> updatePost(@PathVariable Long postId, @Validated @RequestBody Post post) {
        Post updated = updatePostService.run(postId, post);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<?> getPostById(
            @PathVariable Long postId) {
        return getPostByIdPostService.run(postId);
    }

}
