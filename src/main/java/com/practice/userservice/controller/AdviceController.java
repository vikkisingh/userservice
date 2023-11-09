package com.practice.userservice.controller;

import com.practice.userservice.dto.ErrorResponseDto;
import com.practice.userservice.exception.UserOrPasswordMisMatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AdviceController {

    @ExceptionHandler(UserOrPasswordMisMatchException.class)
    public ResponseEntity<ErrorResponseDto> mismatchException(Exception e){
        ErrorResponseDto error =new ErrorResponseDto();
        error.setErrorMessage(e.getMessage());
        return  new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
