package com.company.controller;

import com.company.entity.Role;
import com.company.entity.User;
import com.company.serviceImpl.RoleServiceImpl;
import com.company.serviceImpl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private RoleServiceImpl roleService;

    @GetMapping("id={id}")
    public ResponseEntity<User> getUserById(@PathVariable("id")Long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }
    @GetMapping("email={email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable("email")String email){
        return ResponseEntity.ok(userService.getUserByEmail(email));
    }
    @GetMapping("userid={id}")
    public ResponseEntity<List<Role>> getUserByEmail(@PathVariable("id")Long id){
        List<Long> userRoleIds = userService.getIdsOfUserRoles(id);
        List<Role> userRoles = new ArrayList<>();
        userRoleIds.forEach((roleId)->userRoles.add(roleService.getRoleById(roleId)));
        return ResponseEntity.ok(userRoles);
    }
}
