package com.example.hitservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRequest {
    private String username;

    private String password;

    private String firstName;

}
