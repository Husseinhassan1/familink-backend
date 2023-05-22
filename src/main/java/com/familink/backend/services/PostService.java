package com.familink.backend.services;
import com.familink.backend.models.PostDto;
import com.familink.backend.models.entities.Post;
import com.familink.backend.repositories.PostRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {

        this.postRepository = postRepository;
    }

    public PostDto createPost(PostDto postDto) {
        Post entity = toEntity(postDto);
        entity = postRepository.save(entity);

        return toDto(entity);
    }

    public List<PostDto> getPostList() {
        List<Post> posts = postRepository.findAll();
        List<PostDto> result = new ArrayList<>();
        for (Post post : posts) {
            result.add(toDto(post));
        }
        return result;
    }

    public PostDto getPost(long id) {
        Post entity = getEntity(id);
        return toDto(entity);
    }

    public PostDto updatePost(long id, PostDto dto) {
        Post entity = getEntity(id);
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setAgeGroup(dto.getAgeGroup());
        entity.setPrivacy(dto.getPrivacy());
//        entity.setTags(dto.getTags());
        Post post = postRepository.save(entity);

        return toDto(post);
    }

    public void deletePost(long id) {
        postRepository.deleteById(id);
    }

    private static PostDto toDto(Post post) {
        return new PostDto(post.getId(),
                post.getTitle(),
                post.getDescription(),
                post.getAgeGroup(),
//                post.getTags(),
                post.getPrivacy());
    }

    private static Post toEntity(PostDto postDto) {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
//        post.setTags(postDto.getTags());
        post.setAgeGroup(postDto.getAgeGroup());
        post.setPrivacy(postDto.getAgeGroup());
        return post;
    }

    private Post getEntity(long id) {
        Optional<Post> postOptional = postRepository.findById(id);
        if(postOptional.isPresent()) {
            return postOptional.get();
        }

        throw new RuntimeException("Post with id:" + id + " does not exist!");
    }

}
