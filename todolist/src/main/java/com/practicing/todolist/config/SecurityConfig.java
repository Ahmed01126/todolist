package com.practicing.todolist.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // for POST from Postman, disable CSRF
                .authorizeHttpRequests()
                .requestMatchers("/auth","/auth/register","/auth/login").permitAll() // allow unauthenticated access
                .anyRequest().authenticated()
                .and()
                .httpBasic(); // or .formLogin(), or your JWT filter

        return http.build();
    }
}

