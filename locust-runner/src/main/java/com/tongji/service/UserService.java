package com.tongji.service;

import com.tongji.domain.UserInfo;



public interface UserService {

    UserInfo find(String id);

    void add(UserInfo user);

    void update(UserInfo user);

    void updatePassword(UserInfo user);
}
