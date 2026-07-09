package com.vikas.lovable.entity;


import com.vikas.lovable.enums.ProjectRole;
import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectMember {


    private ProjectMemberId id;

    private Project project;

    private User user;

    private ProjectRole role;

    private LocalDateTime invitedAt;

    private LocalDateTime acceptedAt;
}
