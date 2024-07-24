package com.meditrack.meditrack.utils;

import lombok.*;
import org.springframework.http.HttpStatus;

@Builder
@Getter@Setter
@ToString
@AllArgsConstructor
public class GenericResponse<T> {

    private T data ;
    private String responseMessage ;
    private HttpStatus status ;
    private Integer statusCode ;
}
