package com.hms.HMSApplication.exception;

import lombok.Data;

@Data
public class HMSException extends Exception{
    private Integer requestId;
    private String message;
    private String errorCode;

    public HMSException(String message, String errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }

    public HMSException(String message, Throwable cause, String message1, String errorCode) {
        super(message, cause);
        this.message = message1;
        this.errorCode = errorCode;
    }

    public HMSException(String errorCode) {
        this.errorCode = errorCode;
    }
}
