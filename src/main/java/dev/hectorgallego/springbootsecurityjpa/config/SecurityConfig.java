package dev.hectorgallego.springbootsecurityjpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import dev.hectorgallego.springbootsecurityjpa.service.JpaUserDetailService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private final JpaUserDetailService jpaUserDetailService;

    public SecurityConfig(JpaUserDetailService jpaUserDetailService) {
        this.jpaUserDetailService = jpaUserDetailService;
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http
            .csrf(csrf-> csrf.disable())// si no se desabilita el csrf no se pueden enviar solicitudes post
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/users","/home").permitAll()
                .anyRequest()
                .authenticated()
            )
            .userDetailsService(jpaUserDetailService)
            .headers(headers -> headers
                .frameOptions()
                .sameOrigin()
            )
            .httpBasic(Customizer.withDefaults())
            .build();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
