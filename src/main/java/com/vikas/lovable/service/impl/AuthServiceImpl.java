package com.vikas.lovable.service.impl;

import com.vikas.lovable.dto.auth.AuthResponse;
import com.vikas.lovable.dto.auth.LoginRequest;
import com.vikas.lovable.dto.auth.SignupRequest;
import com.vikas.lovable.entity.User;
import com.vikas.lovable.error.BadRequestException;
import com.vikas.lovable.mapper.UserMapper;
import com.vikas.lovable.repo.UserRepository;
import com.vikas.lovable.security.AuthUtil;
import com.vikas.lovable.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

   private final UserRepository userRepository;
   private final UserMapper userMapper;
   private final PasswordEncoder passwordEncoder;
   private final AuthUtil authUtil;
   private final AuthenticationManager authenticationManager;

    @Override
    public AuthResponse signup(SignupRequest request) {
          userRepository.findByUsername(request.username()).ifPresent(user -> {
              throw new BadRequestException("User Already with username : "+request.username());
          });
        User user=userMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user=userRepository.save(user);
        String token= authUtil.generateAccessToken(user);
        return new AuthResponse(token,userMapper.toUserProfileResponse(user));
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        Authentication authentication= authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.username(),request.password())
        );
        User user=(User)authentication.getPrincipal();
        String token= authUtil.generateAccessToken(user);

        return new AuthResponse(token,userMapper.toUserProfileResponse(user));
    }
}
