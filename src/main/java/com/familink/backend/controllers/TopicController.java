package com.familink.backend.controllers;


import com.familink.backend.models.TopicDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/topic")
@AllArgsConstructor
@Slf4j
public class TopicController {

    @PostMapping
    public void createTopic(@RequestBody TopicDto topicDto){

    }
}
