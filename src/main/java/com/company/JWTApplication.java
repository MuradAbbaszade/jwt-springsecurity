package com.company;

import com.company.configuration.WebSecurityConfig;
import com.company.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class JWTApplication {
    @Autowired
    UserServiceImpl userService;
    @Bean
    public CommandLineRunner run() {
        CommandLineRunner clr = new CommandLineRunner() {
            @Override
            public void run(String... args) {
                String password = userService.getUserById(new Long(1)).getPassword();
                String encodedPassword = passwordEncoder().encode(password);
                userService.getUserById(new Long(1)).setPassword(encodedPassword);
            }

        };
        return clr;
    }
    public static void main(String[] args){
        SpringApplication.run(JWTApplication.class, args);
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
