package com.familink.backend.controllers.posts;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {

    private Long id;
    private String title;
    private String url;
    private String description;
    private String username;
    private Integer likeCount;
    private Integer commentCount;


}
