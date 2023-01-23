package com.example.hitservice.repository;

import com.example.hitservice.domain.HitUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<HitUser,Long> {
    HitUser findByUsername(String username);
}
