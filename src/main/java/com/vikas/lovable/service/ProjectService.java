package com.vikas.lovable.service;

import com.vikas.lovable.dto.project.ProjectRequest;
import com.vikas.lovable.dto.project.ProjectResponse;
import com.vikas.lovable.dto.project.ProjectSummaryResponse;

import java.util.List;

public interface ProjectService {

    List<ProjectSummaryResponse> getUserProjects(Long userId);

    ProjectResponse getUserProjectById(Long userId, Long id);

    ProjectResponse updateProject(Long id, Long userId, ProjectRequest request);

    ProjectResponse createProject(ProjectRequest request, Long userId);


    void deleteProject(Long id, Long userId);
}
