package com.mdmytriaha.controllet;

import com.mdmytriaha.model.Role;
import com.mdmytriaha.model.User;
import com.mdmytriaha.repository.RoleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class RoleController {

    @Autowired
    RoleRepository roleRepository;

    @RequestMapping(value = "/role/{id}", method = RequestMethod.GET)
    public Role getById(@PathVariable long id) {
        return roleRepository.findOne(id);
    }

    @RequestMapping(value = "/role", method = RequestMethod.POST)
    public Role create(@RequestBody Role user) {
        return roleRepository.saveAndFlush(user);
    }


    @RequestMapping(value = "/role/{id}", method = RequestMethod.PUT)
    public Role update(@PathVariable long id, @RequestBody Role role) {
        Role existingRole = roleRepository.findOne(id);
        BeanUtils.copyProperties(role, existingRole);
        return roleRepository.saveAndFlush(existingRole);
    }

    @RequestMapping(value = "role/{id}", method = RequestMethod.DELETE)
    public Role delete(@PathVariable long id) {
        Role existingRole = roleRepository.findOne(id);
        roleRepository.delete(existingRole);
        return existingRole;
    }
}
