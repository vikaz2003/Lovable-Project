package com.vikas.lovable.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter
@AllArgsConstructor
public class ResourceNotFoundException extends RuntimeException{

    private String resourceName;
    private String resourceId;
}
