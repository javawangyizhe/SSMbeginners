package com.offcn.service.impl;

import com.offcn.mapper.UserMapper;
import com.offcn.pojo.User;
import com.offcn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User findUserByUser(User user) {
        User user1 = userMapper.findUserByUser(user);
        return user1;
    }
}
