package com.company.service;

import org.springframework.stereotype.Service;

@Service
public interface TokenManager {
    boolean validateToken(String token);
    String generateToken(String username);
    String getUsernameToken(String token);
    boolean isExpired(String token);
}
