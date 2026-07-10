package com.vikas.lovable.dto.member;

import com.vikas.lovable.enums.ProjectRole;

import java.time.LocalDateTime;

public record MemberResponse(
        Long userId,
        String email,
        String name,
        String avatarUrl,
        ProjectRole role,
        LocalDateTime invitedAt
) {
}
