package com.company.service;

import com.company.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User getUserByEmail(String email);
    User getUserById(Long id);
    boolean saveUser(User user);
    void deleteUserById(Long id);
    List<User> getAll();
}
