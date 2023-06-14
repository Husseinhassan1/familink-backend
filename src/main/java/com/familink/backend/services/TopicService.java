package com.familink.backend.services;


import com.familink.backend.mapper.TopicMapper;
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
    private final TopicMapper topicMapper;

    @Transactional
    public TopicDto save(TopicDto topicDto){
       Topic save = topicRepository.save(topicMapper.mapDtoToTopic(topicDto));
       topicDto.setId(save.getId());
       return topicDto;
    }

    @Transactional(readOnly = true)
    public List<TopicDto> getAll() {
       return topicRepository.findAll()
                .stream()
                .map(topicMapper::mapTopicToDto)
                .collect(toList());
    }

    
}
