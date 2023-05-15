/*
package com.familink.backend.repositories;

import jakarta.persistence.*;
import lombok.*;
import com.familink.backend.models.entities.Post;
import com.familink.backend.models.entities.User;


@Entity
@Table(name = "comment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}
*/