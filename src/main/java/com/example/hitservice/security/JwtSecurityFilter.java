package com.example.hitservice.security;


import com.example.hitservice.payroll.JwtAuthException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

@Component
public class JwtSecurityFilter extends GenericFilterBean {

    private final JwtProvider jwtProvider;

    public JwtSecurityFilter(JwtProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String token = jwtProvider.resolveToken((HttpServletRequest) request);

        try {
            if (token != null && jwtProvider.validateToken(token)) {

                Authentication authentication = jwtProvider.getAuthentication(token);

                if (authentication != null) {
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        } catch (RuntimeException e) {
//            ((HttpServletResponse) response).sendError(403, e.getMessage());
        }
        chain.doFilter(request, response);
    }



}

