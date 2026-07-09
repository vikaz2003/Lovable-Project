package com.vikas.lovable.dto.auth;

public record LoginRequest(
        String email,
        String password
) {
}
