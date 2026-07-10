package com.vikas.lovable.mapper;


import com.vikas.lovable.dto.project.ProjectResponse;
import com.vikas.lovable.dto.project.ProjectSummaryResponse;
import com.vikas.lovable.entity.Project;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {


    ProjectResponse toResponse(Project project);

    List<ProjectSummaryResponse> toProjectSummaryResponseList(List<Project> project);

    ProjectSummaryResponse toSummaryResponse(Project project);
}
