package com.imcd.evaluation.exception;

import com.imcd.evaluation.code.ErrorCode;
import lombok.Getter;

@Getter
public class JwtRuntimeException extends RuntimeException {

    private ErrorCode errorCode;
    private String message;
    public JwtRuntimeException(ErrorCode errorCode) {
        super(errorCode.getDescription());
        this.errorCode = errorCode;
        this.message = errorCode.getDescription();
    }

    public JwtRuntimeException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        this.message = message;
    }

    public JwtRuntimeException(String message) {
        super(message);
    }
}
