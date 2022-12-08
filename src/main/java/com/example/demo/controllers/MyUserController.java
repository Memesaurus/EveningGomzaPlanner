package com.example.demo.controllers;

import com.example.demo.dto.MyUserRegisterDto;
import com.example.demo.models.MyUser;
import com.example.demo.services.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class MyUserController {
    @Autowired
    MyUserService myUserService;

    @GetMapping
    public List<MyUser> getAllUsers() {
        return myUserService.getAllUsers();
    }

    @PostMapping
    public void registerNewUser(@RequestBody MyUserRegisterDto myUserRegisterDto) throws ResponseStatusException {
        myUserService.addUser(myUserRegisterDto);
    }
}
