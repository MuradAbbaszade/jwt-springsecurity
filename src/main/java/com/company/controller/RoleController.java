package com.company.controller;

import com.company.entity.Role;
import com.company.serviceImpl.RoleServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
@RequiredArgsConstructor
public class RoleController {
    @Autowired
    private RoleServiceImpl roleService;

    @GetMapping("id={id}")
    public ResponseEntity<Role> getRoleById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(roleService.getRoleById(id));
    }

    @GetMapping("name={name}")
    public ResponseEntity<Role> getRoleByName(@PathVariable("name") String name) {
        return ResponseEntity.ok(roleService.getRoleByName(name));
    }
}
