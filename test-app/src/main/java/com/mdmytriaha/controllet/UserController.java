package com.mdmytriaha.controllet;

import com.mdmytriaha.model.User;
import com.mdmytriaha.service.impl.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class UserController {

    private UserService userService;

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public List<User> getAll() {
        return userService.getAll();
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User getById(@PathVariable long id) {
        return userService.getById(id);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User create(@RequestBody User user) {
        return userService.add(user);
    }


    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public User update(@PathVariable long id, @RequestBody User user) {
        User existingUser = userService.getById(id);
        BeanUtils.copyProperties(user, existingUser);
        return userService.edit(existingUser);
    }

    @RequestMapping(value = "user/{id}", method = RequestMethod.DELETE)
    public User delete(@PathVariable long id) {
        return userService.delete(id);
    }
}
