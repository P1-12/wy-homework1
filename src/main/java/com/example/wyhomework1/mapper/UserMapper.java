package com.example.wyhomework1.mapper;

import com.example.wyhomework1.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    Integer reg(User user);

    User findByUsername(String username);

    User findByUid(Integer uid);

    Integer updateUserInfo(
            @Param("uid") Integer uid,
            @Param("username") String username,
            @Param("password") String password,
            @Param("salt") String salt
    );

    Integer deleteUser(@Param("uid") Integer uid);
}
