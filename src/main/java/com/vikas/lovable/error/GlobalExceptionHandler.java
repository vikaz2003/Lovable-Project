package com.vikas.lovable.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;


@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiError> handleBadRequest(BadRequestException e){
        ApiError apiError=new ApiError(HttpStatus.BAD_REQUEST,e.getMessage());
        log.error(apiError.toString(),e);
        return ResponseEntity.badRequest().body(apiError);
    }


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleResourceNotFoundRequest(ResourceNotFoundException e){
        ApiError apiError=new ApiError(HttpStatus.NOT_FOUND,e.getResourceName()+" with id "+e.getResourceId());
        log.error(apiError.toString(),e);
        return ResponseEntity.badRequest().body(apiError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleMethodArgumentNotValidRequest(MethodArgumentNotValidException e){
        List<ApiError.ApiFieldError> errors=e.getBindingResult().getFieldErrors().stream()
                .map(error->new ApiError.ApiFieldError(error.getField(),error.getDefaultMessage()))
                .toList();
        ApiError apiError=new ApiError(HttpStatus.BAD_REQUEST,"Input Validation Failed",errors );
        log.error(apiError.toString(),e);
        return ResponseEntity.badRequest().body(apiError);
    }
}
