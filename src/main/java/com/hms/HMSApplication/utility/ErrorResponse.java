package com.hms.HMSApplication.utility;

import lombok.Data;

@Data
public class ErrorResponse {
    private Integer requestId;
    private String errorMessage;
    private String errorCode;
}
