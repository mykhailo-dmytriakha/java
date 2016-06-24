package com.mdmytriaha.service;

import com.mdmytriaha.model.User;

import java.util.List;

public interface IUserService {
    User add(User entity);
    User delete(long id);
    User getById(long id);
    User edit (User entity);
    List<User> getAll();
}
