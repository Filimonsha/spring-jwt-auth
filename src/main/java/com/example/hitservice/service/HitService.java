package com.example.hitservice.service;

import com.example.hitservice.domain.Hit;
import com.example.hitservice.dto.HitRequest;
import com.example.hitservice.payroll.HitNotFoundException;
import com.example.hitservice.repository.HitRepository;
import com.example.hitservice.utils.Computer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HitService {
    private final HitRepository hitRepository;

    public HitService(HitRepository hitRepository) {
        this.hitRepository = hitRepository;
    }

    public Hit getHit(Long id){
        return hitRepository.findById(id).orElseThrow(()-> new HitNotFoundException(id));
    }
    public List<Hit> getAllHits() {
        return hitRepository.findAll();
    }

    public Hit saveHit(HitRequest hitRequest) {
        Hit createdHit = new Hit();
        Double x  = hitRequest.getX();
        Double y = hitRequest.getY();
        Double r = hitRequest.getR();
        createdHit.setX(x);
        createdHit.setY(y);
        createdHit.setR(r);
        createdHit.setHit(Computer.calculateHit(x,y,r));
        return hitRepository.save(createdHit);
    }
}
