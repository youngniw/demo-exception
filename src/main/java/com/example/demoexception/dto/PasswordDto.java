package com.example.demoexception.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class PasswordDto {
    @NotBlank(message = "blank: Before Password not entered")
    private String beforePassword;

    @NotBlank(message = "blank: After Password not entered")
    private String afterPassword;
}
