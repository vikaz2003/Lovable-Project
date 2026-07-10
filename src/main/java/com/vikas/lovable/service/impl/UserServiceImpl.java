package com.vikas.lovable.service.impl;

import com.vikas.lovable.dto.auth.UserProfileResponse;
import com.vikas.lovable.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserProfileResponse getProfile(Long userId) {
        return null;
    }
}
