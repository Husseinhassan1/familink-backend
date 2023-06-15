package com.familink.backend.repositories;


import com.familink.backend.models.entities.Post;
import com.familink.backend.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<User> findById(String id);

}
