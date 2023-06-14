package com.familink.backend.controllers;

import com.familink.backend.models.CommentDto;
import com.familink.backend.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    //create
    @PostMapping("/{id}")
    public CommentDto createComment(@RequestBody CommentDto commentDto) {
        return commentService.createComment(commentDto);
    }

    //retrieve comment
    @GetMapping("/{id}")
    public CommentDto getComment(@PathVariable Long id) {
        return commentService.getComment(id);
    }
}

/*
    //retrieve all comments for a post

    @GetMapping
    public List<CommentDto> getPostComments(){
        return CommentService.getCommentList();
    }
*/