package com.mdmytriaha.service.impl;

import com.mdmytriaha.model.Role;
import com.mdmytriaha.repository.RoleRepository;
import com.mdmytriaha.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements IService<Role> {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role add(Role entity) {
        return roleRepository.saveAndFlush(entity);
    }

    @Override
    public Role delete(long id) {
        Role role = roleRepository.findOne(id);
        roleRepository.delete(role);
        return role;
    }

    @Override
    public Role getById(long id) {
        return roleRepository.findOne(id);
    }

    @Override
    public Role edit(Role entity) {
        return roleRepository.saveAndFlush(entity);
    }

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }
}
