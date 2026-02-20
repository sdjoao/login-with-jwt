package com.projeto.login.with.jwt.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.login.with.jwt.dto.UserRequestDTO;
import com.projeto.login.with.jwt.dto.UserResponseDTO;
import com.projeto.login.with.jwt.service.UserService;

@RestController
@RequestMapping("/register")
public class RegisterController {
    
    private final UserService userService;

    public RegisterController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> register(@RequestBody UserRequestDTO request){
        return ResponseEntity.status(201).body( userService.createUser(request));
    }
}
