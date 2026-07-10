package com.vikas.lovable.service;

import com.vikas.lovable.dto.subscription.CheckoutRequest;
import com.vikas.lovable.dto.subscription.CheckoutResponse;
import com.vikas.lovable.dto.subscription.PortalResponse;
import com.vikas.lovable.dto.subscription.SubscriptionResponse;

public interface SubscriptionService {
    SubscriptionResponse getCurrentSubscription();

    CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request, Long userId);

    PortalResponse openCustomerPortal(Long userId);
}
