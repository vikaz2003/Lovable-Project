package com.vikas.lovable.dto.project;

import java.time.LocalDateTime;

public record FileNode(
        String path,
        LocalDateTime modifiedAt,
        Long size,
        String type
) {
}
