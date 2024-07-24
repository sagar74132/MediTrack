package com.meditrack.meditrack.utils;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class GenericException extends Exception {

    private final HttpStatus status;
    private final Integer statusCode;
    private final String errorMsg;

    public GenericException(String errorMsg) {
        this.errorMsg = errorMsg;
        this.status = HttpStatus.BAD_REQUEST;
        this.statusCode = status.value();
    }

    public GenericException(String errorMsg, HttpStatus status) {
        this.errorMsg = errorMsg;
        this.status = status;
        this.statusCode = status.value();
    }
}
