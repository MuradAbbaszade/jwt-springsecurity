package com.company.service;

import com.company.entity.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {
    Role getRoleById(Long id);
    Role getRoleByName(String name);
    boolean saveRole(Role role);
    void deleteRoleById(Long id);
    List<Role> getAll();
}
