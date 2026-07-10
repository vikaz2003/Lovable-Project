package com.vikas.lovable.entity;

import com.vikas.lovable.enums.PreviewStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

//@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Preview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Project project;
    private String  namespace;
    private String podName;
    private String previewUrl;
    private PreviewStatus status;
    private LocalDateTime startedAt;
    private LocalDateTime terminatedAt;
    private LocalDateTime createdAT;
}
