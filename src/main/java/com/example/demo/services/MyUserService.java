package com.example.demo.services;

import com.example.demo.dto.MyUserRegisterDto;
import com.example.demo.models.MyUser;
import com.example.demo.repositories.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MyUserService implements UserDetailsService {
    @Autowired
    private MyUserRepository myUserRepository;

    public List<MyUser> getAllUsers() {
        return myUserRepository.findAll();
    }

    public void addUser(MyUserRegisterDto myUserRegisterDto) throws ResponseStatusException {
        String username = myUserRegisterDto.getUsername();
        if (Boolean.TRUE.equals(myUserRepository.existsByUsername(username))) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username " + username + " is taken!");
        }
        String password = myUserRegisterDto.getPassword();
        MyUser newUser = new MyUser(
                username,
                password,
                "ROLE_USER");
        myUserRepository.save(newUser);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return myUserRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found!"));
    }
}
