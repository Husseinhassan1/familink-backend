package com.familink.backend.controllers;

import com.familink.backend.models.User;
import com.familink.backend.services.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/login")
@RestController
public class LoginController {

    private final UserDetailsService userDetailsService;

    LoginController(UserDetailsService userDetailsService) { this.userDetailsService = userDetailsService;}

    @GetMapping
    public User getUser(@PathVariable long id) {
        return userDetailsService.getUser(id);
    }
}
