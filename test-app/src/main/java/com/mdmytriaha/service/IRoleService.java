package com.mdmytriaha.service;

import com.mdmytriaha.model.Role;

import java.util.List;

public interface IRoleService {
    Role add(Role entity);
    Role delete(long id);
    Role getById(long id);
    Role edit (Role entity);
    List<Role> getAll();
}
