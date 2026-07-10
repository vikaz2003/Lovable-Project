package com.vikas.lovable.service.impl;

import com.vikas.lovable.dto.subscription.CheckoutRequest;
import com.vikas.lovable.dto.subscription.CheckoutResponse;
import com.vikas.lovable.dto.subscription.PortalResponse;
import com.vikas.lovable.dto.subscription.SubscriptionResponse;
import com.vikas.lovable.service.SubscriptionService;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Override
    public SubscriptionResponse getCurrentSubscription() {
        return null;
    }

    @Override
    public CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request, Long userId) {
        return null;
    }

    @Override
    public PortalResponse openCustomerPortal(Long userId) {
        return null;
    }
}
