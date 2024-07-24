package com.meditrack.meditrack.utils;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(GenericException.class)
    @ResponseBody
    public ResponseEntity<GenericResponse<String>> handleGenericException(GenericException ex) {
        GenericResponse<String> response = GenericResponse.<String>builder()
                .responseMessage(ex.getErrorMsg())
                .statusCode(ex.getStatusCode())
                .status(ex.getStatus())
                .build();
        return new ResponseEntity<>(response, response.getStatus());
    }
}