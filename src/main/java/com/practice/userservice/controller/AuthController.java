package com.practice.userservice.controller;

import com.practice.userservice.dto.ValidateRequestDTO;
import com.practice.userservice.exception.UserOrPasswordMisMatchException;
import com.practice.userservice.model.Session;
import com.practice.userservice.model.User;
import com.practice.userservice.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private AuthService authService;

    public AuthController(AuthService authService){
        this.authService=authService;
    }

    @PostMapping("/signup")
    public String signup(@RequestBody User user){

        return authService.signup(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) throws UserOrPasswordMisMatchException {

        return authService.login(user.getEmail(), user.getPassword());
    }

    @PostMapping("/validate")
    public boolean validate(@RequestBody ValidateRequestDTO requestDTO){

        return authService.validate(requestDTO.getToken(),requestDTO.getUserId());
    }
}
