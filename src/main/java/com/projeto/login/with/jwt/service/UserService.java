package com.projeto.login.with.jwt.service;

import org.springframework.stereotype.Service;

import com.projeto.login.with.jwt.dto.UserRequestDTO;
import com.projeto.login.with.jwt.dto.UserResponseDTO;
import com.projeto.login.with.jwt.entity.User;
import com.projeto.login.with.jwt.exception.BusinessException;
import com.projeto.login.with.jwt.mapper.UserMapper;
import com.projeto.login.with.jwt.repository.UserRepository;

@Service
public class UserService {
    
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    private boolean isValid(UserRequestDTO request){
        if(userRepository.existsByEmail(request.email())){
            throw new BusinessException("Email já está em uso.");
        }
        if(request.email() == null || request.email().isBlank()){
            throw new BusinessException("Email vazio ou inválido.");
        }
        if(request.name() == null || request.name().isBlank()){
            throw new BusinessException("Nome de usuário vazio ou inválido.");
        }
        if(request.password() == null || request.password().isBlank()){
            throw new BusinessException("Senha inválida, não pode ser vazia.");
        }
        return true;
    }

    public UserResponseDTO createUser(UserRequestDTO request, String hashPass){
        isValid(request);
        User user = new User();
        user.setName(request.name());
        user.setEmail(request.email());
        user.setPassword(hashPass);
        userRepository.save(user);
        return UserMapper.conversor(user);
    }
}
