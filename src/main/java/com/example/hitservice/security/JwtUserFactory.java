package com.example.hitservice.security;

import com.example.hitservice.domain.HitUser;
import com.example.hitservice.security.JwtUser;

public class JwtUserFactory {
    public static JwtUser create(HitUser user) {
        return new JwtUser(
                user.getId(),
                user.getUsername(),
                user.getPassword()
        );
    }
}
