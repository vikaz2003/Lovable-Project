package com.vikas.lovable.dto.member;

import com.vikas.lovable.enums.ProjectRole;

public record InviteMemberRequest(
        String email,
        ProjectRole role
) {
}
