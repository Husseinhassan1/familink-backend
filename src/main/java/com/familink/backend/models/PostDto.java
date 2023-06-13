package com.familink.backend.models;

import com.familink.backend.models.entities.Tag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
    private String privacy;
    private List<Tag> tags;

    public PostDto(Long id, String title, String description, String ageGroup, List<Tag> tags, String image, String privacy) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.ageGroup = ageGroup;
        this.tags = tags;
        this.image = image;
        this.privacy = privacy;
    }
}
