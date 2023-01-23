package com.example.hitservice.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class HitUser {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String password;

    private String firstName;
    public HitUser(){}

    public HitUser(String username, String password, String firstName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
    }
}
