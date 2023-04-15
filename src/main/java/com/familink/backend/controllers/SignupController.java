package com.familink.backend.controllers;
import com.familink.backend.models.User;
import com.familink.backend.services.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/signup")
@RestController
public class SignupController {

    private final UserDetailsService userDetailsService;

    SignupController(UserDetailsService userDetailsService) { this.userDetailsService = userDetailsService;}
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userDetailsService.createUser(user);
    }
}
