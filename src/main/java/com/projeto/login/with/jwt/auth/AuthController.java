package com.projeto.login.with.jwt.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.login.with.jwt.dto.LoginRequestDTO;
import com.projeto.login.with.jwt.dto.LoginResponseDTO;

@RestController
@RequestMapping("/auth")
public class AuthController {
    
    private final AuthService authService;


    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO request){
        return ResponseEntity.ok(authService.login(request));
    }

    
}
