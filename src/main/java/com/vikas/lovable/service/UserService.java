package com.vikas.lovable.service;

import com.vikas.lovable.dto.auth.UserProfileResponse;

public interface UserService {

    UserProfileResponse getProfile(Long userId);
}
