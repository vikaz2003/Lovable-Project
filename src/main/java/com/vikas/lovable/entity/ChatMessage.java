package com.vikas.lovable.entity;

import com.vikas.lovable.enums.MessageRole;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

//@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private ChatSession chatSession;

    private MessageRole role;
    private String content;
    private String toolCalls;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
