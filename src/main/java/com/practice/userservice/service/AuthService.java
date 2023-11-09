package com.practice.userservice.service;

import com.practice.userservice.exception.UserOrPasswordMisMatchException;
import com.practice.userservice.model.User;

public interface AuthService {
    public String signup(User user);

    public String login(String email,String password) throws UserOrPasswordMisMatchException;

    public boolean validate(String token,Long userId);
}
