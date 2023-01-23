package com.example.hitservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateTokenRequest {

    private String username;

    private String password;

}
