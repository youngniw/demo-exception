package com.example.demoexception.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberDto {
    private final Long memberId;
    private final String name;
    private final Integer birthYear;

    @Builder
    public MemberDto(Long memberId, String name, Integer birthYear) {
        this.memberId = memberId;
        this.name = name;
        this.birthYear = birthYear;
    }
}
