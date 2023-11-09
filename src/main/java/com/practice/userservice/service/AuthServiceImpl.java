package com.practice.userservice.service;

import com.practice.userservice.exception.UserOrPasswordMisMatchException;
import com.practice.userservice.model.Session;
import com.practice.userservice.model.User;
import com.practice.userservice.repository.AuthRepository;
import com.practice.userservice.repository.SessionRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private AuthRepository authRepository;
    private SessionRepository sessionRepository;

    public AuthServiceImpl(AuthRepository authRepository,SessionRepository sessionRepository){
        this.authRepository=authRepository;
        this.sessionRepository=sessionRepository;
    }
    @Override
    public String signup(User user) {
        User user1=authRepository.save(user);
        return user1.getEmail();
    }

    @Override
    public String login(String email, String password) throws UserOrPasswordMisMatchException {
        User user=authRepository.findUserByEmail(email);
        Session session=new Session();
        if(password.equals(user.getPassword())){
            String token=RandomStringUtils.randomAlphanumeric(20);
            session.setToken(token);
            session.setUser(user);
            session=sessionRepository.save(session);
            return session.getToken();
        }else{
            throw new UserOrPasswordMisMatchException("username or password mismatch Exception");
        }
        //return session.getToken();
    }

    @Override
    public boolean validate(String token, Long userId) {
        Session session=sessionRepository.findSessionByTokenAndUser_Id(token,userId);
        if(session==null){
            return false;
        }
        return true;
    }

}
