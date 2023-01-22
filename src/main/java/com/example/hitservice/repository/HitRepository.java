package com.example.hitservice.repository;

import com.example.hitservice.domain.Hit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HitRepository extends JpaRepository<Hit,Long>
{
}
