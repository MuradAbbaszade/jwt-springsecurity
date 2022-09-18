package com.company.controller;

import com.company.entity.User;
import com.company.serviceImpl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appuser")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private UserServiceImpl appUserService;
    @GetMapping("id={id}")
    public ResponseEntity<User> getUserById(@PathVariable("id")Long id){
        return ResponseEntity.ok(appUserService.getUserById(id));
    }
    @GetMapping("email={email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable("email")String email){
        return ResponseEntity.ok(appUserService.getUserByEmail(email));
    }
}
