package com.vikas.lovable.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

public record ApiError(
        HttpStatus status,
        String message,
        LocalDateTime timestamp,
        @JsonInclude(JsonInclude.Include.NON_NULL) List<ApiFieldError> errors
) {

    public ApiError(HttpStatus status,String message){
      this(status,message,LocalDateTime.now(),null);
    }

    public ApiError(HttpStatus status,String message,List<ApiFieldError> errors){
        this(status,message,LocalDateTime.now(),errors);
    }


    record ApiFieldError(String field,String message)
    {

    }
}
