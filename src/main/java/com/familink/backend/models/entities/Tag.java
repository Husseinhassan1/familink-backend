package com.familink.backend.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
    @Table(name = "tag")
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Builder
    public class Tag{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "tagname")
        private String tagName;

        @ManyToMany
        @JoinTable(name = "post_tag",
        joinColumns = @JoinColumn(name = "tag_id"),
        inverseJoinColumns = @JoinColumn(name = "post_id"))
        private List<Post> posts;

    // Getters and setters for the properties
    public String getTagName() {
        return tagName;
    }
    public void setTagName(String tagName) {
        this.tagName = tagName;
    }


}
