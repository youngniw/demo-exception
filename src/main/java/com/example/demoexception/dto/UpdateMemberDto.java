package com.example.demoexception.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class UpdateMemberDto {
    @NotBlank(message = "blank: Name not entered")
    private String name;
}
