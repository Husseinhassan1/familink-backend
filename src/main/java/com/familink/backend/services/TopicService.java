package com.familink.backend.services;


import com.familink.backend.models.TopicDto;
import com.familink.backend.models.entities.Topic;
import com.familink.backend.repositories.TopicRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
@Slf4j
public class TopicService {
    private final TopicRepository topicRepository;

    @Transactional
    public TopicDto save(TopicDto topicDto){
       Topic save = topicRepository.save(mapTopicDto(topicDto));
       topicDto.setId(save.getId());
       return topicDto;
    }

    @Transactional(readOnly = true)
    public List<TopicDto> getAll() {
       return topicRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(toList());
    }

    private TopicDto mapToDto(Topic topic) {
        return TopicDto.builder()
                .name(topic.getName())
                .id(topic.getId())
                .numberOfPosts(topic.getPosts().size())
                .build();
    }

    private Topic mapTopicDto(TopicDto topicDto) {
        return Topic.builder()
                .name(topicDto.getName())
                .description(topicDto.getDescription())
                .build();
    }


}
