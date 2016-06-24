package com.mdmytriaha.service.impl;

import com.mdmytriaha.model.Role;
import com.mdmytriaha.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends BaseService<Role> {

    @Autowired
    private static RoleRepository roleRepository;


    public RoleService() {
        super(roleRepository);
    }
}
