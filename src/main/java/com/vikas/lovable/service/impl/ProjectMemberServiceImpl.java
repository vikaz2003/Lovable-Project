package com.vikas.lovable.service.impl;


import com.vikas.lovable.dto.member.InviteMemberRequest;
import com.vikas.lovable.dto.member.MemberResponse;
import com.vikas.lovable.dto.member.UpdateMemberRoleRequest;
import com.vikas.lovable.repo.ProjectMemberRepo;
import com.vikas.lovable.service.ProjectMemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProjectMemberServiceImpl implements ProjectMemberService {

    private final ProjectMemberRepo projectMemberRepo;
    

    @Override
    public List<MemberResponse> getProjectMembers(Long projectId, Long userId) {
        return List.of();
    }

    @Override
    public MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId) {
        return null;
    }

    @Override
    public MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest request, Long userId) {
        return null;
    }

    @Override
    public MemberResponse deleteProjectMember(Long projectId, Long memberId, Long userId) {
        return null;
    }
}
