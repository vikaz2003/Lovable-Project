package com.vikas.lovable.controller;

import com.vikas.lovable.dto.project.ProjectRequest;
import com.vikas.lovable.dto.project.ProjectResponse;
import com.vikas.lovable.dto.project.ProjectSummaryResponse;
import com.vikas.lovable.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<ProjectSummaryResponse>> getMyProjects(){
        Long userId=1L;
        return ResponseEntity.ok(projectService.getUserProjects(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectResponse> getProjectByID(@PathVariable Long id){
         Long userId=1L;
         return ResponseEntity
                 .ok(projectService.getUserProjectById(userId,id));

    }

    @PostMapping
    public ResponseEntity<ProjectResponse> createProject(@RequestBody ProjectRequest request){
        Long userId=1L;
        return ResponseEntity.status(HttpStatus.CREATED).body(projectService.createProject(request,userId));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProjectResponse> updateProject(@PathVariable Long id,@RequestBody ProjectRequest request){
        Long userId=1L;
        return ResponseEntity.ok(projectService.updateProject(id,userId,request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> updateProject(@PathVariable Long id){
        Long userId=1L;
        return ResponseEntity.ok(projectService.deleteProject(id,userId));
    }


}
