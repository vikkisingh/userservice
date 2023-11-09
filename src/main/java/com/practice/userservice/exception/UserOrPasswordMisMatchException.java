package com.practice.userservice.exception;

public class UserOrPasswordMisMatchException extends Exception{
    public UserOrPasswordMisMatchException(String msg){
        super(msg);
    }
}
