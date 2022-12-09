package com.example.demoexception.exception.code;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public enum ErrorCode {
    ALL_INTERNAL_EXCEPTION(500, HttpStatus.INTERNAL_SERVER_ERROR, "서버 내부 오류입니다."),

    NOT_VALID_PARAMETER(400, HttpStatus.BAD_REQUEST, "요청 정보가 유효하지 않습니다."),
    NOT_ENTERED_VALUE(40001, HttpStatus.BAD_REQUEST, "입력하지 않은 값이 있습니다."),
    OUT_OF_RANGE_VALUE(40002, HttpStatus.BAD_REQUEST, "값의 유효 범위를 벗어났습니다."),
    FAIL_TO_LOGIN(40011, HttpStatus.BAD_REQUEST, "로그인 정보가 일치하지 않습니다."),
    NOT_EXIST_MEMBER(40012, HttpStatus.BAD_REQUEST, "회원이 존재하지 않습니다."),
    ALREADY_EXIST_MEMBER_NAME(40013, HttpStatus.BAD_REQUEST, "이미 존재하는 이름입니다."),
    ALREADY_EXIST_LOGIN_ID(40013, HttpStatus.BAD_REQUEST, "이미 존재하는 로그인 아이디입니다."),
    NOT_VALID_PASSWORD(40014, HttpStatus.BAD_REQUEST, "기존 비밀번호가 옳지 않습니다.");

    private final Integer id;
    private final HttpStatus status;
    private final String message;

    public int getId() {
        return id;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
