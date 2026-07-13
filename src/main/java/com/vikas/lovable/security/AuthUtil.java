package com.vikas.lovable.security;

import com.vikas.lovable.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;

@Component
public class AuthUtil {


    @Value("jwt.secret-key")
    private String jwtSecretKey;

    public String generateAccessToken(User user){
          return Jwts.builder()
                  .subject(user.getUsername())
                  .claim("userId",user.getId().toString())
                  .issuedAt(new Date())
                  .expiration(new Date(System.currentTimeMillis()+1000*60*60))
                  .signWith(getSecretKey())
                  .compact();
    }

    private SecretKey getSecretKey(){
        return Keys.hmacShaKeyFor(jwtSecretKey.getBytes(StandardCharsets.UTF_8));
    }

    public String getUserName(String token){
        return Jwts.parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    public JwtUserPrincipal verifyAcessToken(String token){
       Claims claims=Jwts.parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
       return new JwtUserPrincipal(Long.parseLong((String) claims.get("userId")), claims.getSubject(),new ArrayList<>());
    }
}
