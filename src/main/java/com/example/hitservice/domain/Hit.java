package com.example.hitservice.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Hit {

    @Id @GeneratedValue private Long id;

    private Double x;

    private Double y;

    private Double r;

    private boolean isHit;

    public boolean isHit() {
        return isHit;
    }

    public void setHit(boolean hit) {
        isHit = hit;
    }

    public Hit(){}

    public Hit(Double x, Double y, Double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }
}
