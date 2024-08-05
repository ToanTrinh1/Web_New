package com.example.web.exception;

public class AppException extends Throwable {
    public AppException(ErrorCode errorCode) {
        super();
        this.errorCode = errorCode;
    }

    private ErrorCode errorCode;

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
