package com.mdmytriaha.controllet;

import com.mdmytriaha.model.Role;
import com.mdmytriaha.service.impl.RoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class RoleController {

    @Autowired
    RoleService roleService;

    @RequestMapping(value = "/role/{id}", method = RequestMethod.GET)
    public Role getById(@PathVariable long id) {
        return roleService.getById(id);
    }

    @RequestMapping(value = "/role", method = RequestMethod.POST)
    public Role create(@RequestBody Role user) {
        return roleService.add(user);
    }


    @RequestMapping(value = "/role/{id}", method = RequestMethod.PUT)
    public Role update(@PathVariable long id, @RequestBody Role role) {
        Role existingRole = roleService.getById(id);
        BeanUtils.copyProperties(role, existingRole);
        return roleService.edit(existingRole);
    }

    @RequestMapping(value = "role/{id}", method = RequestMethod.DELETE)
    public Role delete(@PathVariable long id) {
        return roleService.delete(id);
    }
}
