package com.projeto.login.with.jwt.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Service;

import com.projeto.login.with.jwt.dto.LoginRequestDTO;
import com.projeto.login.with.jwt.dto.LoginResponseDTO;
import com.projeto.login.with.jwt.entity.User;
import com.projeto.login.with.jwt.exception.UnAuthorizedException;
import com.projeto.login.with.jwt.repository.UserRepository;

@Service
public class AuthService {
    
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public LoginResponseDTO login(LoginRequestDTO request) {

        User user = userRepository.findByEmail(request.email())
                .orElseThrow(() -> new UnAuthorizedException("Usuário não encontrado."));

        if (!passwordEncoder.matches(request.password(), user.getPassword())) {
            throw new UnAuthorizedException("Credenciais inválidas.");
        }

        String token = jwtService.gerarToken(user.getEmail());

        return new LoginResponseDTO(token);
    }

   
}
