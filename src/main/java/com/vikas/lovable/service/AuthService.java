package com.vikas.lovable.service;

import com.vikas.lovable.dto.auth.AuthResponse;
import com.vikas.lovable.dto.auth.LoginRequest;
import com.vikas.lovable.dto.auth.SignupRequest;

public interface AuthService {
    AuthResponse signup(SignupRequest request);

    AuthResponse login(LoginRequest request);
}
