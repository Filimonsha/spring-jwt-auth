package com.example.hitservice.controller;

import com.example.hitservice.domain.HitUser;
import com.example.hitservice.dto.CreateUserRequest;
import com.example.hitservice.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/users/")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    List<HitUser> getUsers() {
        return userService.getUsers();
    }

    @PostMapping("/")
    HitUser createUser(@RequestBody CreateUserRequest createUserRequest) {
        return userService.createUser(createUserRequest);
    }


}
