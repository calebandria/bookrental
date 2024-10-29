package com.kaleba.bookrental.bookrental.dto;

import jakarta.validation.constraints.NotBlank;

public class LoginDto {
    
    @NotBlank(message ="username is required")
    private String username;

    @NotBlank(message ="Password is required")
    private String password;
}
