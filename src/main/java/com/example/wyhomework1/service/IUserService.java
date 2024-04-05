package com.example.wyhomework1.service;

import com.example.wyhomework1.entity.User;

public interface IUserService {
    void reg(User user);

    User login(User user);

    void updateUserInfo(Integer uid,User user);

    void deleteUser(Integer uid);
}
