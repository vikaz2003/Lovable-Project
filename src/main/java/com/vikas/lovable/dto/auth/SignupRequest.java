package com.vikas.lovable.dto.auth;

public record SignupRequest(
        String email,
        String password,
        String name
) {
}
