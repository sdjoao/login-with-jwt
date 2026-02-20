package com.projeto.login.with.jwt.dto;

public record UserRequestDTO(
    String name, 
    String email, 
    String password
){}
