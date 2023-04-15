package com.familink.backend.services;

import com.familink.backend.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsService {


    public User createUser(User user) {
        user.setId(91L);
        user.setEmail("test@example.com");
        user.setUsername("testuser");
        user.setFullName("Big User");
        user.setPassword("12345678");
        return user;
    }

    public List<User> getUserList() {
        List<User> result = new ArrayList<>();
        User x = new User(1L,"bigemail@mail.com", "Big Name", "bigusername", "12345678" );
        result.add(x);
        return result;
    }

    public User getUser(long id) {
        return new User(id, "bigemail@mail.com", "Big Name", "bigusername", "12345678" );
    }

    public User updateUser(long id, User user) {
        System.out.println("User found: " + id);
        user.setId(id);
        user.setEmail("");
        user.setUsername("");
        user.setFullName("");
        user.setPassword("");
        return user;
    }

    public void deleteUser(long id) {
        System.out.println("Deleted " + id);
    }
}
