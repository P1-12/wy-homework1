package com.example.wyhomework1.service;

import com.example.wyhomework1.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class UserServiceTests {
    @Autowired
    private IUserService userService;

    @Test
    public void reg(){
        User user = new User();
        user.setUsername("a");
        user.setPassword("123");
        userService.reg(user);
    }

    @Test
    public void login(){
        User user = new User();
        user.setUsername("hhhhhh");
        user.setPassword("123");
        System.out.println(userService.login(user));
    }
}
