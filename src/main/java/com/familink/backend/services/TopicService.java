package com.familink.backend.services;


import com.familink.backend.models.TopicDto;
import com.familink.backend.models.entities.Topic;
import com.familink.backend.repositories.TopicRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class TopicService {
    private final TopicRepository topicRepository;

    public TopicDto save(TopicDto topicDto){
       Topic save = topicRepository.save(mapTopicDto(topicDto));
       topicDto.setId(save.getId());
       return topicDto;
    }

    private Topic mapTopicDto(TopicDto topicDto) {
        return Topic.builder()
                .name(topicDto.getName())
                .description(topicDto.getDescription())
                .build();
    }
}
