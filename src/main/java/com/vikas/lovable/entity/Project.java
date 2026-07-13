package com.vikas.lovable.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "projects",
indexes = {
        @Index(name = "idx_projects_updated_at_desc",columnList = "updated_at DESC,deleted_at"),
        @Index(name = "idx_projects_deleted_at",columnList = "deleted_at"),
        @Index(name="idx_projects_is_public",columnList = "is_public")
}
)
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String name;

    @Builder.Default
    private Boolean isPublic=false;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;


    private LocalDateTime deletedAt; // soft delete
}
