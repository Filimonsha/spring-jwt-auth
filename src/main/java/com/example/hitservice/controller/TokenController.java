package com.example.hitservice.controller;

import com.example.hitservice.domain.HitUser;
import com.example.hitservice.dto.CreateTokenRequest;
import com.example.hitservice.payroll.UserNotFoundException;
import com.example.hitservice.security.JwtProvider;
import com.example.hitservice.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/tokens/")
public class TokenController {

    private final JwtProvider jwtProvider;
    private final UserService userService;

    public TokenController(JwtProvider jwtProvider, UserService userService) {
        this.jwtProvider = jwtProvider;
        this.userService = userService;
    }

    @PostMapping("/")
    String createToken(@RequestBody CreateTokenRequest createTokenRequest) {
        HitUser hitUser = userService.findByUsername(createTokenRequest.getUsername());
        if (hitUser != null) {
            return jwtProvider.createToken(createTokenRequest.getUsername());
        } else {
            throw new UserNotFoundException(createTokenRequest.getUsername());
        }
    }
}
