package com.example.demoexception.exception.handler;

import com.example.demoexception.exception.code.ErrorCode;
import com.example.demoexception.exception.exception.BadRequestException;
import com.example.demoexception.exception.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice(annotations = RestController.class)
public class ResponseExceptionHandler {

    // @Valid 시, 유효성 검증 실패에 대한 msg 수신 후 처리 (유효하지 않은 파라미터 값 예외 처리)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    protected ErrorResponse badRequestException(MethodArgumentNotValidException exception) {
        if (exception.getBindingResult().hasErrors()) {
            String msg = exception.getBindingResult().getFieldError().getDefaultMessage();

            log.info("[@Valid Error]: {}", msg);

            switch (msg.split(":")[0]) {
                case "blank": {
                    return new ErrorResponse(ErrorCode.NOT_ENTERED_VALUE);
                }
                case "range": {
                    return new ErrorResponse(ErrorCode.OUT_OF_RANGE_VALUE);
                }
            }
        }

        return new ErrorResponse(ErrorCode.NOT_VALID_PARAMETER);
    }

    // 요청 파라미터의 값이 유효하지 않을 때에 따른 커스텀 예외 처리
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = BadRequestException.class)
    protected ErrorResponse badRequestException(BadRequestException exception) {
        return new ErrorResponse(exception.getErrorCode());
    }

    // 전체 예외 처리
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = { Exception.class })
    protected ErrorResponse handleAllException(Exception ex) {
        log.warn(ex.getMessage());

        return new ErrorResponse(ErrorCode.ALL_INTERNAL_EXCEPTION);
    }
}
