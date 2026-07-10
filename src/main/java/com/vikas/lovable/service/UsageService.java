package com.vikas.lovable.service;

import com.vikas.lovable.dto.subscription.PlanLimitsResponse;
import com.vikas.lovable.dto.subscription.UsageTodayResponse;

public interface UsageService {
    UsageTodayResponse getTodayUsageOfUser(Long userId);

    PlanLimitsResponse getCurrentSubscriptionLimitsOfUser(Long userId);
}
