package com.vikas.lovable.dto.auth;

public record AuthResponse(
        String token,
        UserProfileResponse user

) {
}
