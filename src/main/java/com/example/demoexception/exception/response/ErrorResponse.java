package com.example.demoexception.exception.response;

import com.example.demoexception.exception.code.ErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ErrorResponse {
    private final Integer errorId;
    private final HttpStatus errorStatus;
    private final String errorMessage;

    public ErrorResponse(ErrorCode errorCode) {
        this.errorId = errorCode.getId();
        this.errorStatus = errorCode.getStatus();
        this.errorMessage = errorCode.getMessage();
    }
}
