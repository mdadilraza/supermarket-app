package com.eidiko.query.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponseEntity<T> {

    private HttpStatus code;
    private String message;
    private T data;

}
