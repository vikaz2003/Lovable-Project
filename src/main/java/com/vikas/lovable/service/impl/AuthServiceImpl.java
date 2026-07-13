package com.vikas.lovable.service.impl;

import com.vikas.lovable.dto.auth.AuthResponse;
import com.vikas.lovable.dto.auth.LoginRequest;
import com.vikas.lovable.dto.auth.SignupRequest;
import com.vikas.lovable.entity.User;
import com.vikas.lovable.error.BadRequestException;
import com.vikas.lovable.mapper.UserMapper;
import com.vikas.lovable.repo.UserRepository;
import com.vikas.lovable.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

   private final UserRepository userRepository;
   private final UserMapper userMapper;
   private final PasswordEncoder passwordEncoder;

    @Override
    public AuthResponse signup(SignupRequest request) {
          userRepository.findByUsername(request.username()).ifPresent(user -> {
              throw new BadRequestException("User Already with username : "+request.username());
          });
        User user=userMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user=userRepository.save(user);
        return new AuthResponse("dummy",userMapper.toUserProfileResponse(user));
    }

    @Override
    public AuthResponse login(LoginRequest request) {

        return null;
    }
}
