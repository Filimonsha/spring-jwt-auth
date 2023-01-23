package com.example.hitservice.service;

import com.example.hitservice.domain.HitUser;
import com.example.hitservice.dto.CreateUserRequest;
import com.example.hitservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public HitUser createUser (CreateUserRequest createUserRequest){
        HitUser hitUser = new HitUser();
        hitUser.setUsername(createUserRequest.getUsername());
        hitUser.setPassword(createUserRequest.getPassword());
        hitUser.setFirstName(createUserRequest.getFirstName());
        return userRepository.save(hitUser);
    }
    public List<HitUser> getUsers(){
        return userRepository.findAll();
    }

    public HitUser findByUsername(String username){
        return userRepository.findByUsername(username);
    }
}
