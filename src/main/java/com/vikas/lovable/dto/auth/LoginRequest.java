package com.vikas.lovable.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginRequest(
        @Email
        @NotBlank
        String email,
        @Size(min=4,message = "Password should be atleast 4 characters")
        @NotBlank
        String password
) {
}
