package com.vikas.lovable.service;

import com.vikas.lovable.dto.project.FileContentResponse;
import com.vikas.lovable.dto.project.FileNode;

import java.util.List;

public interface FilesService {
    List<FileNode> getFileTree(Long projectId, Long userId);

    FileContentResponse getFileContent(Long projectId, String path, Long userId);
}
