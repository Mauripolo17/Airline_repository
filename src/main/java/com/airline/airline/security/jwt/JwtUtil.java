package com.airline.airline.security.jwt;

import com.airline.airline.security.services.UserDetailsImpl;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.time.LocalDateTime;
import java.util.Date;

@Component
@Slf4j
public class JwtUtil {
    @Value("${app.jwt.secret}")
    private String jwtSecret;
    @Value("${app.jwt.expiration}")
    private String jwtExpirationMs;

    public String generateJwtToken(Authentication autentication){
        UserDetails user = (UserDetailsImpl) autentication.getPrincipal();
        return Jwts.builder()
                .setSubject((user.getUsername()))
                .setIssuedAt(new Date())
                //.setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(key(), SignatureAlgorithm.HS256)
                .compact();
    }

    public Key key(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

    public boolean validateJwtToken(String authToken){
        try {
            Jwts.parserBuilder().setSigningKey(key()).build().parse(authToken);
            return true;
        }catch (MalformedJwtException e ){
            log.error("Invalid JWT token", e.getMessage());
        }catch (ExpiredJwtException e ){
            log.error("Expired JWT token", e.getMessage());
        }catch (UnsupportedJwtException e ){
            log.error("Unsupported JWT token", e.getMessage());
        }catch (IllegalArgumentException e ){
            log.error("JWT token contains invalid characters", e.getMessage());
        }
        return false;
    }

    public String getUsernameFromJwtToken(String authToken){
        return Jwts.parserBuilder().setSigningKey(key()).build()
                .parseClaimsJws(authToken).getBody().getSubject();
    }
}
