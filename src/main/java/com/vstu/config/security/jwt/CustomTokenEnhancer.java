package com.vstu.config.security.jwt;

import com.vstu.config.security.jwt.model.AuthenticatedUser;
import com.vstu.config.security.jwt.model.AuthenticatedUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.List;

@Component
public class CustomTokenEnhancer {

    @Value("${token.signing.key}")
    private String signingKey;

    AuthenticatedUser parseToken(String token) {
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(signingKey.getBytes("UTF-8"))
                    .parseClaimsJws(token)
                    .getBody();

            String email = body.getSubject();
            String role = body.get("role", String.class);
            String tabel = body.get("tabel", String.class);
            System.out.println("Table number: " + tabel);

            List<SimpleGrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + role));
            return new AuthenticatedUser(email, authorities);
        } catch (ExpiredJwtException e) {
            throw new BadCredentialsException("JWT token expired!");
        } catch (UnsupportedEncodingException | JwtException e) {
            throw new BadCredentialsException("JWT token can't be parsed");
        }
    }
}
