package com.company;

import com.company.entity.User;
import com.company.repo.RoleRepository;
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
    @Autowired
    RoleRepository roleRepository;
    @Bean
    BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CommandLineRunner run() {
        CommandLineRunner clr = new CommandLineRunner() {
            @Override
            public void run(String... args) {

            }

        };
        return clr;
    }
    public static void main(String[] args){
        SpringApplication.run(JWTApplication.class, args);
    }
}
