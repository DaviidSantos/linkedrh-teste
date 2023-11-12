package com.linkedrhteste.modules.curso.errors;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalErrorException extends RuntimeException{
    public InternalErrorException(String message) {
        super(message);
    }
}
