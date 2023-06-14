package com.familink.backend.services;

import com.familink.backend.models.CommentDto;
import com.familink.backend.models.entities.Comment;
import com.familink.backend.repositories.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {

        this.commentRepository = commentRepository;
    }

    //create Comment
    public CommentDto createComment(CommentDto CommentDto) {
        Comment entity = toEntity(CommentDto);
        entity = commentRepository.save(entity);

        return toDto(entity);
    }

    //get all comments
    public List<CommentDto> getCommentList() {
        List<Comment> comments= commentRepository.findAll();
        List<CommentDto> result = new ArrayList<>();
        for (Comment comment : comments) {
            result.add(toDto(comment));
        }
        return result;
    }
    //get a comment
    public CommentDto getComment(long id) {
        Comment entity = getEntity(id);
        return toDto(entity);
    }

    private static CommentDto toDto(Comment comment) {
        return new CommentDto(comment.getId(), comment.getContent());
    }

    private static Comment toEntity(CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setContent(commentDto.getContent());
        return comment;
    }

    private Comment getEntity(long id) {
        Optional<Comment> CommentOptional = commentRepository.findById(id);
        if(CommentOptional.isPresent()) {
            return CommentOptional.get();
        }

        throw new RuntimeException("Comment with id:" + id + " does not exist!");
    }

}


