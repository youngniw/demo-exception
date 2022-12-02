package com.example.demoexception.dto;

import lombok.Getter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;

@Getter
public class RegisterDto {
    @NotBlank(message = "blank: Name not entered")
    private String name;

    @NotBlank(message = "blank: Login ID not entered")
    private String loginId;

    @NotBlank(message = "blank: Login Password not entered")
    private String loginPassword;

    @Range(min = 1900, max = 9999, message = "range: Birth year is out of range")
    private int birthYear;
}
