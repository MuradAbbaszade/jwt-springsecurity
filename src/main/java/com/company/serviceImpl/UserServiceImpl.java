package com.company.serviceImpl;

import com.company.entity.Role;
import com.company.entity.User;
import com.company.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.company.service.UserService;

import javax.transaction.Transactional;
import java.util.List;

import static org.graalvm.compiler.phases.common.DeadCodeEliminationPhase.Optionality.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Override
    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    @Override
    public User getUserById(Long id) {
        if(userRepository.findById(id).isPresent()){
            return userRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public boolean saveUser(User user) {
        try{
            userRepository.save(user);
        }
        catch(Exception e){
            return false;
        }
        return true;
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public List<Long> getIdsOfUserRoles(Long userId) {
        return userRepository.getIdsOfUserRoles(userId);
    }

    @Override
    public void addRoleToUser(Long roleId, Long userId) {
        userRepository.addRoleToUser(roleId,userId);
    }
}
