package com.vikas.lovable.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record SignupRequest(
        @Email
        @NotBlank
        String email,
        @Size(min=1,max=30)
        @NotBlank
        String password,

        String name
) {
}
