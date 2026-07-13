package com.vikas.lovable.service.impl;


import com.vikas.lovable.dto.member.InviteMemberRequest;
import com.vikas.lovable.dto.member.MemberResponse;
import com.vikas.lovable.dto.member.UpdateMemberRoleRequest;
import com.vikas.lovable.entity.Project;
import com.vikas.lovable.entity.ProjectMember;
import com.vikas.lovable.entity.ProjectMemberId;
import com.vikas.lovable.entity.User;
import com.vikas.lovable.error.ResourceNotFoundException;
import com.vikas.lovable.mapper.ProjectMemberMapper;
import com.vikas.lovable.repo.ProjectMemberRepo;
import com.vikas.lovable.repo.ProjectRepository;
import com.vikas.lovable.repo.UserRepository;
import com.vikas.lovable.service.ProjectMemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class ProjectMemberServiceImpl implements ProjectMemberService {

    private final ProjectMemberRepo projectMemberRepo;
    private final ProjectRepository projectRepository;
    private final ProjectMemberMapper projectMemberMapper;
    private final UserRepository userRepository;

    @Override
    public List<MemberResponse> getProjectMembers(Long projectId, Long userId) {
        Project project=getAccessibleProjectById(projectId,userId);

        return new ArrayList<>(projectMemberRepo.findByIdProjectId(projectId)
                .stream()
                .map(projectMemberMapper::toMemberResponse)
                .toList());
    }

    @Override
    public MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId) {
        Project project=getAccessibleProjectById(projectId,userId);


        User invitee=  userRepository.findByUsername(request.username()).orElseThrow();
        if(invitee.getId().equals(userId)){
            throw new RuntimeException("Cannot invite yourself");
        }
        ProjectMemberId  projectMemberId=new ProjectMemberId(projectId,invitee.getId());
        if(projectMemberRepo.existsById(projectMemberId)){
            throw new RuntimeException("Cannot invite once again");
        }
        ProjectMember member=ProjectMember.builder()
                .id(projectMemberId)
                .project(project)
                .user(invitee)
                .role(request.role())
                .invitedAt(LocalDateTime.now())
                .build();
        member=projectMemberRepo.save(member);

        return projectMemberMapper.toMemberResponse(member);
    }

    @Override
    public MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest request, Long userId) {
        Project project=getAccessibleProjectById(projectId,userId);
        ProjectMemberId  projectMemberId=new ProjectMemberId(projectId,memberId);
        if(!projectMemberRepo.existsById(projectMemberId)){
            throw new RuntimeException("Member does not exist");
        }
        ProjectMember projectMember=projectMemberRepo.findById(projectMemberId).orElseThrow();
        projectMember.setRole(request.role());
        projectMember=projectMemberRepo.save(projectMember);
        return projectMemberMapper.toMemberResponse(projectMember);


    }

    @Override
    public void deleteProjectMember(Long projectId, Long memberId, Long userId) {
        Project project=getAccessibleProjectById(projectId,userId);

        ProjectMemberId  projectMemberId=new ProjectMemberId(projectId,memberId);
        if(!projectMemberRepo.existsById(projectMemberId)){
            throw new RuntimeException("Member not found in project");
        }
        projectMemberRepo.deleteById(projectMemberId);



    }


    //Internal Function
    public Project getAccessibleProjectById(Long projectId,Long userId){
        return projectRepository.findAccessibleProjectById(projectId,userId).orElseThrow(()-> new ResourceNotFoundException("Project with Owner as User",(projectId.toString()+" "+userId.toString())));
    }
}
