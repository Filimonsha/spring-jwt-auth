package com.example.hitservice.payroll;

public class JwtAuthException extends RuntimeException{
    public JwtAuthException(String message){
        super(message);
    }
}
