package com.tongji.service.impl;

import com.tongji.domain.UserInfo;
import com.tongji.mapper.UserMapper;
import com.tongji.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public UserInfo find(String userAccount) {
        return userMapper.findUser(userAccount);
    }

    @Override
    public void add(UserInfo user) {
        userMapper.insert(user);
    }

    @Override
    public void update(UserInfo user) {
        userMapper.update(user);
    }

    @Override
    public void updatePassword(UserInfo user) {userMapper.updatePassword(user); }
}