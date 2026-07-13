package com.vikas.lovable.error;

import lombok.Getter;

@Getter
public class BadRequestException extends RuntimeException{

   private String message;

}
