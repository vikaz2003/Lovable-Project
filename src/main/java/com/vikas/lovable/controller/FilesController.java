package com.vikas.lovable.controller;

import com.vikas.lovable.dto.project.FileContentResponse;
import com.vikas.lovable.dto.project.FileNode;
import com.vikas.lovable.service.FilesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects/{projectId}/files")
@RequiredArgsConstructor
public class FilesController {

    private final FilesService filesService;

    @GetMapping
    public ResponseEntity<List<FileNode>> getFileTree(@PathVariable Long projectId){
        Long userId=1L;
        return ResponseEntity.ok(filesService.getFileTree(projectId
        ,userId));

    }

    @GetMapping("/{*path}")
    public ResponseEntity<FileContentResponse> getFile(
            @PathVariable
            Long projectId,
            @PathVariable String path
    ){
         Long userId=1L;
         return ResponseEntity.ok(filesService.getFileContent(projectId,path,userId));
    }
}
