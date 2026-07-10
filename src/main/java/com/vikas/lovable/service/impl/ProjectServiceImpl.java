package com.vikas.lovable.service.impl;

import com.vikas.lovable.dto.project.ProjectRequest;
import com.vikas.lovable.dto.project.ProjectResponse;
import com.vikas.lovable.dto.project.ProjectSummaryResponse;
import com.vikas.lovable.entity.Project;
import com.vikas.lovable.entity.User;
import com.vikas.lovable.mapper.ProjectMapper;
import com.vikas.lovable.repo.ProjectRepository;
import com.vikas.lovable.repo.UserRepository;
import com.vikas.lovable.service.ProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final ProjectMapper projectMapper;

    @Override
    @Transactional
    public ProjectResponse createProject(ProjectRequest request, Long userId) {
        User owner=userRepository.findById(userId).orElseThrow();
        Project project=Project.builder()
                .name(request.name())
                .owner(owner)
                .build();
        project=projectRepository.save(project);
        return projectMapper.toResponse(project);
    }

    @Override
    public List<ProjectSummaryResponse> getUserProjects(Long userId) {
        return projectMapper.toProjectSummaryResponseList(projectRepository.findAllAccessibleByUser(userId));
    }

    @Override
    public ProjectResponse getUserProjectById(Long userId, Long id) {
        return null;
    }

    @Override
    public ProjectResponse updateProject(Long id, Long userId, ProjectRequest request) {
        return null;
    }



    @Override
    public Void deleteProject(Long id, Long userId) {
        return null;
    }
}
