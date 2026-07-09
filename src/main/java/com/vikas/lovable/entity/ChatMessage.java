package com.vikas.lovable.entity;

import com.vikas.lovable.enums.MessageRole;
import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ChatMessage {

    private Long id;
    private ChatSession chatSession;

    private MessageRole role;
    private String content;
    private String toolCalls;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
