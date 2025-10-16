package com.example.challenge.service.posts.impl;

import com.example.challenge.model.Post;
import com.example.challenge.model.User;
import com.example.challenge.repository.PostRepository;
import com.example.challenge.repository.UserRepository;
import com.example.challenge.service.posts.GetPostByIdPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class GetPostByIdPostServiceImpl implements GetPostByIdPostService {

    @Autowired
    PostRepository postRepository;
    @Autowired
    UserRepository userRepository;


    @Override
    public ResponseEntity<?> run(Long postId) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        User currentUser = userRepository.findByEmail(userDetails.getUsername()).orElseThrow();


        Post post = postRepository.findById(postId).orElseThrow();

        if (!post.getUser().getId().equals(currentUser.getId())) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("No podés acceder a un post que no es tuyo");
        }

        return ResponseEntity.ok(post);
    }
}
