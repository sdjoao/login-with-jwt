package com.projeto.login.with.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.login.with.jwt.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    
}
