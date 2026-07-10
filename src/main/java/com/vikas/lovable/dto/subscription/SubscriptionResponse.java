package com.vikas.lovable.dto.subscription;

import java.time.LocalDateTime;

public record SubscriptionResponse(
        PlanResponse plan,
        String status,
        LocalDateTime periodEnd,
        Long tokensUsedThisCycle
) {
}
