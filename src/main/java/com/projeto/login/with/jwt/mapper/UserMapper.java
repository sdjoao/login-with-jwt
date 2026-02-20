package com.projeto.login.with.jwt.mapper;

import java.util.List;

import com.projeto.login.with.jwt.dto.UserResponseDTO;
import com.projeto.login.with.jwt.entity.User;

public class UserMapper {
    
    public static UserResponseDTO conversor(User user){
        return new UserResponseDTO(
            user.getId(),
            user.getEmail()
        );
    }

    public static List<UserResponseDTO> listConversor(List<User> users){
        return users
            .stream()
            .map(user -> new UserResponseDTO(
            user.getId(),
            user.getEmail()
        ))
        .toList();
    }
}
