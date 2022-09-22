package com.company.serviceImpl;

import com.company.service.TokenManager;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenManagerImpl implements TokenManager {

    private final int validity = 300000;
    private final String secretKey = "Murad";
    @Override
    public boolean validateToken(String token) {
        if(getUsernameToken(token) !=null && !isExpired(token)){
            return true;
        }
        return false;
    }

    @Override
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuer("Murad")
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+validity))
                .signWith(SignatureAlgorithm.HS256,secretKey)
                .compact();
    }

    @Override
    public String getUsernameToken(String token) {
        return getClaims(token).getSubject();
    }

    @Override
    public boolean isExpired(String token) {
        return getClaims(token).getExpiration().after(new Date(System.currentTimeMillis()));
    }

    public Claims getClaims(String token){
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
    }
}
