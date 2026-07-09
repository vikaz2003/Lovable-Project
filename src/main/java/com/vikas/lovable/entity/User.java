package com.vikas.lovable.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String email;
   private String passwordHash;
   private String name;

   private String avatarUrl;
   private LocalDateTime createdAt;
   private LocalDateTime updatedAt;
   private LocalDateTime deletedAt;

}
