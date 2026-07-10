package com.vikas.lovable.service.impl;

import com.vikas.lovable.dto.subscription.PlanLimitsResponse;
import com.vikas.lovable.dto.subscription.UsageTodayResponse;
import com.vikas.lovable.service.UsageService;
import org.springframework.stereotype.Service;

@Service
public class UsageServiceImpl implements UsageService {
    @Override
    public UsageTodayResponse getTodayUsageOfUser(Long userId) {
        return null;
    }

    @Override
    public PlanLimitsResponse getCurrentSubscriptionLimitsOfUser(Long userId) {
        return null;
    }
}
