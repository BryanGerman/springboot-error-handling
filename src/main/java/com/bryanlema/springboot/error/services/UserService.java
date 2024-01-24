package com.bryanlema.springboot.error.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bryanlema.springboot.error.models.domain.User;

@Service
public class UserService implements IUserService {

    @Autowired
    private List<User> users;

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public Optional<User> findById(Long id) {        
        return users.stream().filter((p) -> p.getId().equals(id)).findFirst();
    }

}
