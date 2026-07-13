package com.vikas.lovable.dto.member;

import com.vikas.lovable.enums.ProjectRole;
import jakarta.validation.constraints.NotNull;

public record UpdateMemberRoleRequest(
        @NotNull
        ProjectRole role) {

}
