package com.vikas.lovable.controller;


import com.vikas.lovable.dto.auth.AuthResponse;
import com.vikas.lovable.dto.auth.LoginRequest;
import com.vikas.lovable.dto.auth.SignupRequest;
import com.vikas.lovable.dto.auth.UserProfileResponse;
import com.vikas.lovable.service.AuthService;
import com.vikas.lovable.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signup(@RequestBody @Valid SignupRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.signup(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody @Valid LoginRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.login(request));

    }

    @GetMapping("/me")
    public ResponseEntity<UserProfileResponse> getProfile(){
        Long userId=1L;

        return ResponseEntity.ok(userService.getProfile(userId));

    }

}
