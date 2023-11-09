package com.practice.userservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidateRequestDTO {
    private String token;
    private Long userId;
}
