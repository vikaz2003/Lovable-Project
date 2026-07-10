package com.vikas.lovable.service.impl;

import com.vikas.lovable.dto.auth.AuthResponse;
import com.vikas.lovable.dto.auth.LoginRequest;
import com.vikas.lovable.dto.auth.SignupRequest;
import com.vikas.lovable.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public AuthResponse signup(SignupRequest request) {
        return null;
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        return null;
    }
}
