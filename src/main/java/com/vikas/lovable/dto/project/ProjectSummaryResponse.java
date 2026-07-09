package com.vikas.lovable.dto.project;

import java.time.LocalDateTime;

public record ProjectSummaryResponse(
        Long id,
        String name,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
