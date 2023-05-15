package com.familink.backend.controllers;

import com.familink.backend.models.PostDto;
import com.familink.backend.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    //create
    @PostMapping("/create")
    public PostDto createPost(@RequestBody PostDto post){
        return postService.createPost(post);
    }

    //edit
    @PutMapping("/{id}")
    public PostDto updatePost(@PathVariable long id, @RequestBody PostDto post){
        return postService.updatePost(id, post);
    }

    //delete
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable long id){
        postService.deletePost(id);
    }

    //retrieve post
    @GetMapping("/{id}")
    public PostDto getPost(@PathVariable Long id){
        return postService.getPost(id);
    }

    //retrieve all posts
    @GetMapping
    public List<PostDto> getAllPosts(){
        return postService.getPostList();
    }
//    @GetMapping(params = "username")
//    public ResponseEntity<List<PostResponse>> getPostsByUsername(@RequestParam String username){
//        return status(HttpStatus.OK).body(postService.getPostsByUsername(username));
//    }

}
