package com.company.filter;

import com.company.service.TokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtTokenFilter extends OncePerRequestFilter {

    @Autowired
    TokenManager tokenManager;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization");
        String username=null;
        String token=null;
        if(authHeader!=null && authHeader.contains("Bearer")){
            token = authHeader.substring(7);
            try{
                username = tokenManager.getUsernameToken(token);
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        if(token!=null && username!=null && SecurityContextHolder.getContext()
                .getAuthentication()==null){
            if(tokenManager.validateToken(token)) {
                UsernamePasswordAuthenticationToken upAuthToken = new UsernamePasswordAuthenticationToken(username, token);
                upAuthToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(upAuthToken);
            }
        }
        filterChain.doFilter(request,response);

    }
}
