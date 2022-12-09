package com.example.demoexception.exception.exception;

import com.example.demoexception.exception.code.ErrorCode;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BadRequestException extends RuntimeException {
    public static final BadRequestException FAIL_TO_LOGIN = new BadRequestException(ErrorCode.FAIL_TO_LOGIN);
    public static final BadRequestException NOT_EXIST_MEMBER = new BadRequestException(ErrorCode.NOT_EXIST_MEMBER);
    public static final BadRequestException ALREADY_EXIST_MEMBER_NAME = new BadRequestException(ErrorCode.ALREADY_EXIST_MEMBER_NAME);
    public static final BadRequestException ALREADY_EXIST_LOGIN_ID = new BadRequestException(ErrorCode.ALREADY_EXIST_LOGIN_ID);

    public static final BadRequestException NOT_VALID_PASSWORD = new BadRequestException(ErrorCode.NOT_VALID_PASSWORD);

    private final ErrorCode errorCode;

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
