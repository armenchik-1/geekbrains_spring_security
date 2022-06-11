package com.example.geekbrains_spring_security.controllers;

import com.example.geekbrains_spring_security.entities.User;
import com.example.geekbrains_spring_security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class MainController {

    private final UserService userService;

    public MainController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String homePage() {
        return "home";
    }

    @GetMapping("/authenticated")
    public String pageForAuthenticatedUsers(Principal principal) {
//        Authentication a = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(principal.getName());
        return String.format("secured part of web service: %s %s", user.getUsername(), user.getEmail());
    }

    @GetMapping("/read_profile")
    public String pageForReadProfile() {
        return "read profile page";
    }

    @GetMapping("/only_for_admins")
    public String pageForAdmins() {
        return "admin's page";
    }

}
