package com.vikas.lovable.dto.project;

import com.vikas.lovable.dto.auth.UserProfileResponse;

import java.time.LocalDateTime;

public record  ProjectResponse(
        Long id,
        String name,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        UserProfileResponse owner
) {
}
