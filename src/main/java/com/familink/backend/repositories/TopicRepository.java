package com.familink.backend.repositories;

import com.familink.backend.models.entities.Topic;
import com.familink.backend.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {

    //Optional<Topic> findByName(String topicName);
    Optional<Topic> findById(String id);
}
