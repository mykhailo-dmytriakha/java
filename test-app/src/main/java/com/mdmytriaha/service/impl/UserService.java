package com.mdmytriaha.service.impl;

import com.mdmytriaha.model.User;
import com.mdmytriaha.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<User> {

    @Autowired
    private static UserRepository userRepository;

    public UserService() {
        super(userRepository);
    }
}
