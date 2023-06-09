package com.familink.backend.controllers;


import com.familink.backend.models.PostDto;
import com.familink.backend.models.TopicDto;
import com.familink.backend.services.TopicService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/topic")
@AllArgsConstructor
@Slf4j
public class TopicController {

    private final TopicService topicService;
    @PostMapping
    public ResponseEntity<TopicDto> createTopic(@RequestBody TopicDto topicDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(topicService.save(topicDto));
    }

    @GetMapping
    public ResponseEntity<List<TopicDto>> getAllTopics(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(topicService.getAll());
    }
    
    @GetMapping("/{id}")
    public TopicDto getPost(@PathVariable Long id){
        return topicService.getTopic(id);
    }
}
