package com.familink.backend.services;


import com.familink.backend.data.PostTest;
import com.familink.backend.models.PostDto;
import com.familink.backend.models.entities.Post;
import com.familink.backend.repositories.PostRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
public class PostServiceUnitTest {
    @MockBean
    private PostRepository postRepository;



    @TestConfiguration
    static class PostServiceTestConfiguration {

        @Bean
        @Primary
        public PostService postService(PostRepository postRepository) {
            return new PostService(postRepository);
        }
    }

    @Autowired
    private PostService postService;

    @Test
    public void givenPost_whenGetPostList_thenListShouldBeFound() {
        // arrange
        Mockito.when(postRepository.findAll())
                .thenReturn(List.of(PostTest.post()));

        // act
        List<PostDto> returnedList = postService.getPostList();

        // assert
        assertThat(returnedList).hasSize(1);
    }
    @Test
    public void givenNoPost_whenGetPostList_thenListShouldBeEmpty() {
        // act
        List<PostDto> returnedList = postService.getPostList();

        // assert
        assertThat(returnedList).isEmpty();
    }

    @Test
    public void givenValidId_whenGetPost_thenPostShouldBeFound() {
        // arrange
        long id = 1L;
        Mockito.when(postRepository.findById(id))
                .thenReturn(Optional.of(PostTest.post()));

        // act
        PostDto resultPost = postService.getPost(id);

        // assert
        assertThat(resultPost.getTitle()).isEqualTo("title1");
    }

    @Test
    public void givenInvalidId_whenGetPost_thenExceptionShouldBeThrown() {
        assertThatThrownBy(() -> postService.getPost(3L))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("does not exist");
    }

    @Test
    public void givenPost_whenCreatePost_thenPostIsReturned() {
        // arrange
        PostDto inputPostDto = PostTest.postDto1();
        inputPostDto.setId(0L); // reset id
        Post outputPost = PostTest.post();

        Mockito.when(postRepository.save(any(Post.class)))
                .thenReturn(outputPost);

        // act
        PostDto resultPost = postService.createPost(inputPostDto);

        // assert
        assertThat(resultPost).isNotNull();
        assertThat(resultPost.getTitle()).isEqualTo(inputPostDto.getTitle());
        assertThat(resultPost.getId()).isNotEqualTo(0L);
    }

    @Test
    public void givenPost_whenCreatePost_thenRepositoryCalled() {
        // arrange
        PostDto postDto = PostTest.postDto3();

        Mockito.when(postRepository.save(any(Post.class)))
                .thenReturn(PostTest.post());

        // act
        postService.createPost(postDto);

        // assert
        verify(postRepository, times(1)).save(any(Post.class));
    }

    @Test
    public void givenPostAndValidId_whenUpdate_thenPostReturned() {
        // arrange
        PostDto inputPostDto = PostTest.postDto1();
        inputPostDto.setId(0L); // reset id
        long id = 1L;
        Post outputPost = PostTest.post();
        outputPost.setId(id);

        Mockito.when(postRepository.findById(id))
                .thenReturn(Optional.of(outputPost));
        Mockito.when(postRepository.save(any(Post.class)))
                .thenReturn(outputPost);

        // act
        PostDto resultPost = postService.updatePost(id, inputPostDto);

        // assert
        assertThat(resultPost).isNotNull();
        assertThat(resultPost.getTitle()).isEqualTo(inputPostDto.getTitle());
        assertThat(resultPost.getId()).isEqualTo(id);
    }

    @Test
    public void givenInvalidId_whenUpdate_thenExceptionShouldBeThrown() {
        assertThatThrownBy(() -> postService.updatePost(2L, PostTest.postDto3()))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("does not exist");
    }

    @Test
    public void givenPost_whenDelete_thenRepositoryCalled() {
        // arrange
        long id = 2L;

        // act
        postService.deletePost(id);

        // assert
        verify(postRepository, times(1)).deleteById(id);
    }
}
