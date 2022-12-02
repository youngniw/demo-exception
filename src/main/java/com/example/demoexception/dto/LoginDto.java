package com.example.demoexception.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class LoginDto {
    @NotBlank(message = "blank: Login ID not entered")
    private String loginId;

    @NotBlank(message = "blank: Login Password not entered")
    private String loginPassword;
}
