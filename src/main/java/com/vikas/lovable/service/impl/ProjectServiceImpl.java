package com.vikas.lovable.service.impl;

import com.vikas.lovable.dto.project.ProjectRequest;
import com.vikas.lovable.dto.project.ProjectResponse;
import com.vikas.lovable.dto.project.ProjectSummaryResponse;
import com.vikas.lovable.entity.Project;
import com.vikas.lovable.entity.ProjectMember;
import com.vikas.lovable.entity.ProjectMemberId;
import com.vikas.lovable.entity.User;
import com.vikas.lovable.enums.ProjectRole;
import com.vikas.lovable.error.ResourceNotFoundException;
import com.vikas.lovable.mapper.ProjectMapper;
import com.vikas.lovable.repo.ProjectMemberRepo;
import com.vikas.lovable.repo.ProjectRepository;
import com.vikas.lovable.repo.UserRepository;
import com.vikas.lovable.service.ProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final ProjectMapper projectMapper;
    private final ProjectMemberRepo projectMemberRepo;

    @Override
    public ProjectResponse createProject(ProjectRequest request, Long userId) {
        User owner=userRepository.getReferenceById(userId);
        Project project=Project.builder()
                .name(request.name())
                .build();
        project=projectRepository.save(project);
        ProjectMemberId projectMemberId=new ProjectMemberId(project.getId(), owner.getId());
        ProjectMember projectMember=ProjectMember.builder()
                .project(project)
                .user(owner)
                .role(ProjectRole.OWNER)
                .acceptedAt(LocalDateTime.now())
                .invitedAt(LocalDateTime.now())
                .id(projectMemberId)
                .build();
        projectMemberRepo.save(projectMember);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public List<ProjectSummaryResponse> getUserProjects(Long userId) {
        return projectMapper.toProjectSummaryResponseList(projectRepository.findAllAccessibleByUser(userId));
    }

    @Override
    public ProjectResponse getUserProjectById(Long userId, Long id) {
        Project project=projectRepository.findAccessibleProjectById(userId,id).orElseThrow(()->new ResourceNotFoundException("Project",id.toString()));
        return projectMapper.toProjectResponse(project);
    }

    @Override
    @Transactional
    public ProjectResponse updateProject(Long id, Long userId, ProjectRequest request) {
        Project project=projectRepository.findAccessibleProjectById(userId,id).orElseThrow(()->new ResourceNotFoundException("Project",id.toString()));
        project.setName(request.name());
        project=projectRepository.save(project);
        return projectMapper.toProjectResponse(project);
    }



    @Override
    @Transactional
    public void deleteProject(Long id, Long userId) {
        Project project=projectRepository.findAccessibleProjectById(userId,id).orElseThrow(()->new ResourceNotFoundException("Project",id.toString()));

        project.setDeletedAt(LocalDateTime.now());
        projectRepository.save(project);

    }
}
