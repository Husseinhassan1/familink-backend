package com.familink.backend.models.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "post")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "age_group")
    private String ageGroup;

    @Column(name = "privacy")
    private String privacy;

    @Lob
    @Column(name = "image")
    private String image;

    @ManyToMany(mappedBy = "posts")
    private List<Tag> tags;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="appUser")
    private User appUser;

}
