package com.divina.pastelaria.seguranca;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class FiltroDeSeguranca {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.csrf(c -> c.disable())
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/index", "/user/login").permitAll()
                        .requestMatchers("/caixa").hasAuthority("dono")
                        .requestMatchers("/usuarios/**").hasAuthority("dono")
                        .requestMatchers("/menu").hasAnyAuthority("dono", "funcionario")
                        .requestMatchers("/js/**", "/css/**", "/imagens/**", "/favicon/**").permitAll()
                        .anyRequest().authenticated()

                )

                .formLogin(f -> f
                        .loginPage("/index")
                        .loginProcessingUrl("/user/login")
                        .defaultSuccessUrl("/menu")
                        .failureUrl("/index")
                        .permitAll()
                )

                .sessionManagement(s -> s
                        .maximumSessions(1)
                ).build();
    }

    //Encriptar Senha no Banco De Dados
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
