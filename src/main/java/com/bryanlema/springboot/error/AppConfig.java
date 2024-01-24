package com.bryanlema.springboot.error;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bryanlema.springboot.error.models.domain.User;

@Configuration
public class AppConfig {
     
    @Bean
    List<User> users(){
        List<User> usersData = new ArrayList<>();
        usersData.add(new User(1L, "Bryan", "Lema"));
        usersData.add(new User(2L, "Maria", "Perez"));
        usersData.add(new User(3L, "Ale", "Gutierrez"));

        return usersData;
    }

}
