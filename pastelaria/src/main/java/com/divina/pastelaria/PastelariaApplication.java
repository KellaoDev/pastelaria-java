package com.divina.pastelaria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class PastelariaApplication {

    public static void main(String[] args) {
        SpringApplication.run(PastelariaApplication.class, args);
    }

    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}