package com.familink.backend.services;

import com.familink.backend.controllers.posts.PostRequest;
import com.familink.backend.controllers.posts.PostResponse;
import com.familink.backend.models.entities.Post;
import com.familink.backend.models.entities.User;
import com.familink.backend.repositories.PostRepository;
import com.familink.backend.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final AuthenticationService authenticationService;

    @PostMapping
    public void save(PostRequest postRequest){
        Post post = new Post();
        post.setTitle(postRequest.getTitle());
        post.setDescription(postRequest.getDescription());
        post.setAgeGroup(postRequest.getAgeGroup());
        post.setAppUser(postRequest.getUser());
        postRepository.save(post);
    }
    @GetMapping
    public PostResponse getPost(Long id){ //f
        postRepository.findById(id);

        return new PostResponse();
    }
    @GetMapping
    public List<PostResponse> getAllPosts(){
        List<Post> posts = postRepository.findAll();
        List<PostResponse> result = new ArrayList<>();
        for (Post post : posts) {
            result.add(new PostResponse(post.getId(),
                    post.getTitle(),
                    post.getDescription(),
                    post.getAgeGroup(),
                    post.getAppUser().toString(),
                    null,
                    null
                    ));
        }

        return result;
    }
    @GetMapping
    public  List<PostResponse> getPostsByUsername(String username){ //f
        User appUser = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        return null;



    }

    //updatePost


}
