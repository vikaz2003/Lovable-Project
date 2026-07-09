package com.vikas.lovable.entity;

import java.time.LocalDateTime;

public class UsageLog {

    private Long id;
    private User user;
    private Project project;
    private String action;
    private Integer tokensUsed;
    private Integer durationMs;
    private String metadata; // JSON of model used,prompt used
    private LocalDateTime createdAt;
}
