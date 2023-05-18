package com.curso.udemy.cursoUdemy.exceptions.handler;


import com.curso.udemy.cursoUdemy.exceptions.ExceptionResponse;
import com.curso.udemy.cursoUdemy.exceptions.UnsupportedMathOperationExcept;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;


@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllExcepections(Exception ex, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(),ex.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UnsupportedMathOperationExcept.class)
    public final ResponseEntity<ExceptionResponse> handleBadRequestExcepections(Exception ex, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(),ex.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

}
