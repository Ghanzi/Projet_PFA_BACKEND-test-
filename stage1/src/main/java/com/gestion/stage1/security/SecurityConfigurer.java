package com.gestion.stage1.security;

import com.gestion.stage1.filter.Oauth2TokenOfflineValidator;
import com.gestion.stage1.helper.JwtTokenVerifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfigurer {



    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http.cors()
                .and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .build();

    }


/*
   @Bean
    public Oauth2TokenOfflineValidator oauth2OfflineValidator(JwtTokenVerifier jwtTokenVerifier){
        return new Oauth2TokenOfflineValidator(jwtTokenVerifier);
    }*/
}
