package com.vikas.lovable.service.impl;

import com.vikas.lovable.dto.project.FileContentResponse;
import com.vikas.lovable.dto.project.FileNode;
import com.vikas.lovable.service.FilesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilesServiceImpl implements FilesService {
    @Override
    public List<FileNode> getFileTree(Long projectId, Long userId) {
        return List.of();
    }

    @Override
    public FileContentResponse getFileContent(Long projectId, String path, Long userId) {
        return null;
    }
}
