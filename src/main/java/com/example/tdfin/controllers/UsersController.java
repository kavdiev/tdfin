package com.example.tdfin.controllers;

import com.example.tdfin.entities.AppUser;
import com.example.tdfin.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersController {

    @Autowired
    AppUserRepository userRepository;

    @GetMapping ("/api/users")
    public List<AppUser> getAllAppUsers () {
        return userRepository.findAll();
    }
}
