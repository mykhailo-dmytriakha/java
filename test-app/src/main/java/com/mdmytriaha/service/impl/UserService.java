package com.mdmytriaha.service.impl;

import com.mdmytriaha.model.User;
import com.mdmytriaha.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<UserRepository, User, Long> {

}
