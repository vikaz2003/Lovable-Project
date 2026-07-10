package com.vikas.lovable.entity;

import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDateTime;

//@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ChatSession {

    private Project project;
    private User user;
    private String title;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
