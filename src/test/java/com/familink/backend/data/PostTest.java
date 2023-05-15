package com.familink.backend.data;


import com.familink.backend.models.PostDto;
import com.familink.backend.models.entities.Post;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PostTest {
    private static long id1 = 1L;
    private static String title1 = "title1";
    private static String description1 = "description1";
    private static String privacy1 = "private";
    private static String ageGroup1 = "ageGroup1";


    public static Post post() {
        Post post = new Post();
        post.setId(id1);
        post.setTitle(title1);
        post.setDescription(description1);
        post.setAgeGroup(ageGroup1);
        post.setPrivacy(privacy1);

        return post;
    }

    public static PostDto postDto1() {
        return new PostDto(id1, title1, description1, ageGroup1, privacy1);
    }

    public static PostDto postDto3() {
        return new PostDto(3L,
                "title2",
                "description2",
                "ageGroup2",
                "privacy2");
    }
}
