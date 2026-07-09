package com.vikas.lovable.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Project project;
    private String path;
    private String minIoObjectKey;
    private LocalDateTime createdAt;
    private User createdBy;
    private User updatedBy;
    private LocalDateTime updatedAt;
}
