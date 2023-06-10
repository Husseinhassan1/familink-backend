package com.familink.backend.models;

import com.familink.backend.models.entities.Tag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostDto {

    private Long id;
    private String title;
    private String description;
    private String ageGroup;

    private String image;

 //  private List<Tag> tags;
    private String privacy;

}
