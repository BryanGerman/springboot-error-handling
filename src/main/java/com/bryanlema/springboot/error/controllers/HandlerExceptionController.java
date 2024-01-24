package com.bryanlema.springboot.error.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.bryanlema.springboot.error.exceptions.UserNotFoundException;
import com.bryanlema.springboot.error.models.Error;


@RestControllerAdvice
public class HandlerExceptionController{

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<Error> divisionByZero(Exception ex){

        Error error = new Error(
            "Error división para 0!",
            ex.getMessage(),
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            new Date()
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(error);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Error> noFoundHandlerException(Exception ex){
        Error e = new Error(
            "Api rest no encontrado", 
            ex.getMessage(), 
            HttpStatus.NOT_FOUND.value(), 
            new Date()
            );
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(e);

    }

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> numberFormatException(Exception ex){

        Map<String, Object> error = new HashMap<>();
        error.put("date", new Date().toString());
        error.put("error", "Numero invalido o incorrecto, no tiene formato de digito!");
        error.put("message", ex.getMessage());
        error.put("code", HttpStatus.INTERNAL_SERVER_ERROR.value());

        return error;
    }
    
    @ExceptionHandler({
        NullPointerException.class,
        UserNotFoundException.class
    })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> userNotFound(Exception ex){

        Map<String, Object> error = new HashMap<>();
        error.put("date", new Date().toString());
        error.put("error", "No se ha encontrado el usuario o rol");
        error.put("message", ex.getMessage());
        error.put("code", HttpStatus.INTERNAL_SERVER_ERROR.value());
        
        return error;
    }

}
