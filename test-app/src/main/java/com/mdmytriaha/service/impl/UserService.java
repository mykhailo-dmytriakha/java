package com.mdmytriaha.service.impl;

import com.mdmytriaha.model.User;
import com.mdmytriaha.repository.UserRepository;
import com.mdmytriaha.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User add(User entity) {
        return userRepository.saveAndFlush(entity);
    }

    @Override
    public User delete(long id) {
        User user = userRepository.findOne(id);
        userRepository.delete(user);
        return user;
    }

    @Override
    public User getById(long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User edit(User entity) {
        return userRepository.saveAndFlush(entity);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
