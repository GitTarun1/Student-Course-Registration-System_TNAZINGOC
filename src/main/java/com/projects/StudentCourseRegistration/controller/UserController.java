package com.projects.StudentCourseRegistration.controller;

import com.projects.StudentCourseRegistration.model.LoginRequest;
import com.projects.StudentCourseRegistration.model.User;
import com.projects.StudentCourseRegistration.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin("*")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public User login(@RequestBody LoginRequest request) {

        return userRepository.login(
                request.getUsername(),
                request.getPassword()
        );
    }
}