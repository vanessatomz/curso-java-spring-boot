package com.curso.udemy.cursoUdemy.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedMathOperationExcept extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public UnsupportedMathOperationExcept(String ex) {
        super(ex);
    }
}

