package com.bryanlema.springboot.error.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.bryanlema.springboot.error.exceptions.UserNotFoundException;
import com.bryanlema.springboot.error.models.domain.User;
import com.bryanlema.springboot.error.services.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    private IUserService userService;
    @GetMapping("/")
    public String index(){
        //int value = 100/0;
        int value = Integer.parseInt("10x");
        //int value = 10;
        System.out.println(value);
        return "ok 200";
    }

    @GetMapping("/show/{id}")
    public User show(@PathVariable Long id){
        User user = userService.findById(id).orElseThrow( () -> new UserNotFoundException("Error el usuario no existe!"));

        // Optional<User> optional = userService.findById(id);
        // if(optional.isEmpty()){
        //     return ResponseEntity.notFound().build();
        // }
        if(user == null){
            throw new UserNotFoundException("Error: el usuario no existe!");
        }
        System.out.println(user.getLastName());
        // return ResponseEntity.ok(optional.orElseThrow());
        return user;
    }
    

    

}
