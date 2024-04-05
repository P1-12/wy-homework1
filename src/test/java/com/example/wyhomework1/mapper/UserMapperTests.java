package com.example.wyhomework1.mapper;

import com.example.wyhomework1.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void reg(){
        User user = new User();
        user.setUsername("123");
        user.setPassword("123");
        user.setSalt("123");
        System.out.println(userMapper.reg(user));
    }

    @Test
    public void findByUsername(){
        System.out.println(userMapper.findByUsername("a"));
    }

    @Test
    public void updateUserInfo(){
        userMapper.updateUserInfo(7,"abc","123","123");
    }

    @Test
    public void deleteUser(){
        userMapper.deleteUser(4);
    }
}
