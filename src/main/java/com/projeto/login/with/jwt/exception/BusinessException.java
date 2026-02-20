package com.projeto.login.with.jwt.exception;


public class BusinessException extends RuntimeException {
    public BusinessException(String message){
        super(message);
    }
}
