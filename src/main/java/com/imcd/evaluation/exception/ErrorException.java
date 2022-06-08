package com.imcd.evaluation.exception;

import com.imcd.evaluation.code.ErrorCode;
import lombok.Getter;

@Getter
public class ErrorException extends RuntimeException {

    private ErrorCode errorCode;
    private String message;

    public ErrorException(ErrorCode errorCode) {
        super(errorCode.getDescription());
        this.errorCode = errorCode;
        this.message = errorCode.getDescription();
    }

    public ErrorException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        this.message = message;
    }
}
