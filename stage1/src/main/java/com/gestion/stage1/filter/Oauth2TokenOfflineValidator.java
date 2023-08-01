package com.gestion.stage1.filter;

import com.gestion.stage1.helper.JwtTokenVerifier;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;


public class Oauth2TokenOfflineValidator extends GenericFilterBean {

    private JwtTokenVerifier jwtTokenVerifier;
    public Oauth2TokenOfflineValidator(JwtTokenVerifier jwtTokenVerifier)
    {
        this.jwtTokenVerifier=jwtTokenVerifier;
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // filterChain.doFilter(servletRequest, servletResponse);

        var request = (HttpServletRequest) servletRequest;
        var response = (HttpServletResponse) servletResponse;

        String requestURI = request.getRequestURI();

        // Exclude token verification for "/api/v1/login" API
        if (requestURI.equals("/api/v1/login")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        //if header is missing , send un-athorized error back

        String authHeader = request.getHeader("Authorization");
        boolean isValid = jwtTokenVerifier.isTokenValid(authHeader);
        if (StringUtils.isEmpty(authHeader) || !isValid) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}