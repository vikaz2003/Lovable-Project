package com.vikas.lovable.security;

import com.vikas.lovable.enums.ProjectRole;
import com.vikas.lovable.repo.ProjectMemberRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("security")
@RequiredArgsConstructor
public class SecurityExpressions {


    private final ProjectMemberRepo projectMemberRepo;
    private final AuthUtil authUtil;

    public boolean canViewProject(Long projectId){
           Long userId= authUtil.getCurrentUserId();

           return projectMemberRepo.findRoleByProjectIdAndUserId(projectId,userId)
                   .map(role-> role.equals(ProjectRole.EDITOR) || role.equals(ProjectRole.VIEWER) || role.equals(ProjectRole.OWNER))
                   .orElse(false);
    }

    public boolean canEditProject(Long projectId){
        Long userId= authUtil.getCurrentUserId();

        return projectMemberRepo.findRoleByProjectIdAndUserId(projectId,userId)
                .map(role-> role.equals(ProjectRole.EDITOR) || role.equals(ProjectRole.OWNER))
                .orElse(false);
    }
}
