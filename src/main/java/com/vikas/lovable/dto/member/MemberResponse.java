package com.vikas.lovable.dto.member;

import com.vikas.lovable.enums.ProjectRole;

import java.time.LocalDateTime;

public record MemberResponse(
        Long userId,
        String username,
        String name,
        ProjectRole role,
        LocalDateTime invitedAt
) {
}
