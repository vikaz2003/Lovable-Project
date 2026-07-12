package com.vikas.lovable.service;

import com.vikas.lovable.dto.member.InviteMemberRequest;
import com.vikas.lovable.dto.member.MemberResponse;
import com.vikas.lovable.dto.member.UpdateMemberRoleRequest;

import java.util.List;

public interface ProjectMemberService {
    List<MemberResponse> getProjectMembers(Long projectId, Long userId);

    MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId);

    MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest request, Long userId);

    void deleteProjectMember(Long projectId, Long memberId, Long userId);
}
