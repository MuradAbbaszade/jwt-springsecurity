package com.company.serviceImpl;

import com.company.entity.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.company.repo.RoleRepository;
import com.company.service.RoleService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;
    @Override
    public Role getRoleById(Long id) {
        if(roleRepository.findById(id).isPresent()){
            return roleRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public Role getRoleByName(String name) {
        return roleRepository.getRoleByName(name);
    }

    @Override
    public boolean saveRole(Role role) {
        try{
            roleRepository.save(role);
        }
        catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public void deleteRoleById(Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }
}
