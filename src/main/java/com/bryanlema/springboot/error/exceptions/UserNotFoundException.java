package com.bryanlema.springboot.error.exceptions;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String message){
        super(message);
    }

}
