package com.vikas.lovable.entity;


import com.vikas.lovable.enums.ProjectRole;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

//@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ProjectMemberId id;

    private Project project;

    private User user;

    private ProjectRole role;

    private LocalDateTime invitedAt;

    private LocalDateTime acceptedAt;
}
