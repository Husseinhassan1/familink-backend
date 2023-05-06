package com.familink.backend.controllers.posts;


import com.familink.backend.models.entities.Tag;
import com.familink.backend.models.entities.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostRequest {

    private Long postId;
    private String title;
    private String description;
    private String ageGroup;
    private String privacy;
    private String url;

    private UserEntity user;
    private File file;

    private Tag tag;

}
