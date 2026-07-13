package com.vikas.lovable.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@Slf4j
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    private final AuthUtil authUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("incoming requests:{}",request.getRequestURI());
       final String authToken=request.getHeader("Authorization");
       if(authToken==null||!authToken.startsWith("Bearer")){
           filterChain.doFilter(request,response);
           return;

       }
       String jwtToken=authToken.split("Bearer ")[1];
       JwtUserPrincipal user=authUtil.verifyAcessToken(jwtToken);
       if(user!=null && SecurityContextHolder.getContext().getAuthentication()==null){
           UsernamePasswordAuthenticationToken passwordAuthenticationToken=new UsernamePasswordAuthenticationToken(
                   user,null,user.roles()
           );
           SecurityContextHolder.getContext().setAuthentication(passwordAuthenticationToken);
       }
       filterChain.doFilter(request,response);
    }
}
