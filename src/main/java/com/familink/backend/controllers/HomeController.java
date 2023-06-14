package com.familink.backend.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@PreAuthorize("hasAnyRole('ADMIN', 'MANAGER', 'USER')")
public class HomeController {


    @GetMapping(value ={"/home"})
    public String home() {
        return "Welcome to the home page";
    }
}
