package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true, prePostEnabled = true)
@SpringBootApplication
public class Demo3Application {
    public static void main(String[] args) {
        SpringApplication.run(Demo3Application.class, args);
    }
}