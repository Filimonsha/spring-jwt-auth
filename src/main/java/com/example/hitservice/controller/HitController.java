package com.example.hitservice.controller;

import com.example.hitservice.domain.Hit;
import com.example.hitservice.dto.HitRequest;
import com.example.hitservice.service.HitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HitController {

    private final HitService hitService;

    public HitController(HitService hitService) {
        this.hitService = hitService;
    }

    @GetMapping("/hits")
    List<Hit> getAll() {
        return hitService.getAllHits();
    }

    @GetMapping("/hits/{id}")
    Hit getOne(@PathVariable Long id){
        return hitService.getHit(id);
    }

    @PostMapping("/hits")
    Hit newHit(@RequestBody HitRequest hitRequest) {
        return hitService.saveHit(hitRequest);
    }

}
