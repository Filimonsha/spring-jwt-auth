package com.example.hitservice.payroll;


public class HitNotFoundException extends RuntimeException {
    public HitNotFoundException(Long id){
        super("Could not find hit " + id);
    }
}
