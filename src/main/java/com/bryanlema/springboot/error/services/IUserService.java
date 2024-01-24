package com.bryanlema.springboot.error.services;

import java.util.List;
import java.util.Optional;

import com.bryanlema.springboot.error.models.domain.User;

public interface IUserService {

    List<User> findAll();
    Optional<User> findById(Long id);
} 
