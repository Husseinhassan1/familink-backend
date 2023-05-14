package com.familink.backend.services;

import com.familink.backend.data.UserTest;
import com.familink.backend.models.UserDto;
import com.familink.backend.models.entities.User;
import com.familink.backend.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.util.List;
import java.util.Optional;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.any;
@RunWith(SpringRunner.class)
public class UserDetailsServiceUnitTest {

    @MockBean
    private UserRepository userRepository;

    private static PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @TestConfiguration
    static class UserDetailsServiceTestConfiguration {

        @Bean
        @Primary
        public CustomUserDetailsService customUserDetailsService(UserRepository userRepository) {
            return new CustomUserDetailsService(userRepository, passwordEncoder);
        }
    }

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Test
    public void givenUser_whenGetUserList_thenListShouldBeFound() {
        // arrange
        Mockito.when(userRepository.findAll())
                .thenReturn(List.of(UserTest.user()));

        // act
        List<UserDto> returnedList = customUserDetailsService.getUserList();

        // assert
        assertThat(returnedList).hasSize(1);
    }
    @Test
    public void givenNoUser_whenGetUserList_thenListShouldBeEmpty() {
        // act
        List<UserDto> returnedList = customUserDetailsService.getUserList();

        // assert
        assertThat(returnedList).isEmpty();
    }

    @Test
    public void givenValidId_whenGetUser_thenUserShouldBeFound() {
        // arrange
        long id = 1L;
        Mockito.when(userRepository.findById(id))
                .thenReturn(Optional.of(UserTest.user()));

        // act
        UserDto resultUser = customUserDetailsService.getUser(id);

        // assert
        assertThat(resultUser.getNickname()).isEqualTo("nickname1");
    }

    @Test
    public void givenInvalidId_whenGetUser_thenExceptionShouldBeThrown() {
        assertThatThrownBy(() -> customUserDetailsService.getUser(3L))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("User not found");
    }

    @Test
    public void givenUser_whenCreateUser_thenUserIsReturned() {
        // arrange
        UserDto inputUserDto = UserTest.userDto1();
        inputUserDto.setId(0L); // reset id
        User outputUser = UserTest.user();

        Mockito.when(userRepository.save(any(User.class)))
                .thenReturn(outputUser);

        // act
        UserDto resultUser = customUserDetailsService.createUser(inputUserDto);

        // assert
        assertThat(resultUser).isNotNull();
        assertThat(resultUser.getNickname()).isEqualTo(inputUserDto.getNickname());
        assertThat(resultUser.getId()).isNotEqualTo(0L);
    }

    @Test
    public void givenUser_whenCreateUser_thenRepositoryCalled() {
        // arrange
        UserDto userDto = UserTest.userDto3();

        Mockito.when(userRepository.save(any(User.class)))
                .thenReturn(UserTest.user());

        // act
        customUserDetailsService.createUser(userDto);

        // assert
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    public void givenUserAndValidId_whenUpdate_thenUserReturned() {
        // arrange
        UserDto inputUserDto = UserTest.userDto1();
        inputUserDto.setId(0L); // reset id
        long id = 1L;
        User outputUser = UserTest.user();
        outputUser.setId(id);

        Mockito.when(userRepository.findById(id))
                .thenReturn(Optional.of(outputUser));
        Mockito.when(userRepository.save(any(User.class)))
                .thenReturn(outputUser);

        // act
        UserDto resultUser = customUserDetailsService.updateUser(id, inputUserDto);

        // assert
        assertThat(resultUser).isNotNull();
        assertThat(resultUser.getNickname()).isEqualTo(inputUserDto.getNickname());
        assertThat(resultUser.getId()).isEqualTo(id);
    }

    @Test
    public void givenInvalidId_whenUpdate_thenExceptionShouldBeThrown() {
        assertThatThrownBy(() -> customUserDetailsService.updateUser(2L, UserTest.userDto3()))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("User not found");
    }

    @Test
    public void givenUser_whenDelete_thenRepositoryCalled() {
        // arrange
        long id = 2L;

        // act
        customUserDetailsService.deleteUser(id);

        // assert
        verify(userRepository, times(1)).deleteById(id);
    }

}
