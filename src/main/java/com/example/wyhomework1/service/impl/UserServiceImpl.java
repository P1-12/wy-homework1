package com.example.wyhomework1.service.impl;

import com.example.wyhomework1.entity.User;
import com.example.wyhomework1.mapper.UserMapper;
import com.example.wyhomework1.service.IUserService;
import com.example.wyhomework1.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.UUID;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void reg(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        if(userMapper.findByUsername(username) != null){
            //数据库查到用户名，抛出用户名已存在异常
            throw new UsernameDuplicatedException();
        }

        //获取盐值（随机生成一个盐值）
        String salt = UUID.randomUUID().toString().toUpperCase();
        //补全数据:盐值的记录
        user.setSalt(salt);
        //将密码和盐值作为一个整体进行加密处理,忽略原有密码强度,提升了数据的安全性
        String md5Password = getMD5Password(password,salt);
        //将加密之后的密码重新补全设置到user对象中
        user.setPassword(md5Password);

        Integer rows = userMapper.reg(user);
        if(rows != 1){
            throw new RegException();
        }
    }

    @Override
    public User login(User user) {
        String username = user.getUsername();
        String password = user.getPassword().trim();
        User result = userMapper.findByUsername(username);
        if(result == null){
            throw new UserNotFoundException();
        }

        //获取数据库盐值
        String salt = result.getSalt();
        String md5Password = getMD5Password(password,salt).trim();

        if(!result.getPassword().equals(md5Password)){
            throw new PasswordErrorException();
        }

        result.setPassword(null);
        result.setSalt(null);
        return result;
    }

    @Override
    public void updateUserInfo(Integer uid,User user) {
        User oldUserInfo = userMapper.findByUid(uid);
        if(oldUserInfo == null){
            throw new UserNotFoundException();
        }

        String password = user.getPassword(); //获取用户输入的密码
        String oldPassword = oldUserInfo.getPassword(); //获取数据库的密码
        String salt = oldUserInfo.getSalt(); //获取数据库盐值
        String md5Password = getMD5Password(password,salt).trim(); //将输入密码加密和数据库进行比对

        /*
        if(md5Password.equals(oldPassword)){
            //比对成功说明用户没有进行密码修改操作，可能是进行了用户名的修改
            String oldUsername = oldUserInfo.getUsername();
            if(!oldUsername.equals(user.getUsername()) && userMapper.findByUsername(user.getUsername()) == null){
                userMapper.updateUserInfo(uid,user.getUsername(),oldUserInfo.getPassword(),oldUserInfo.getSalt());
            }
        }
         */

        if(!md5Password.equals(oldPassword)){
            //比对失败说明用户输入了新密码
            String newSalt = UUID.randomUUID().toString().toUpperCase(); //生成新盐值
            String newPassword = getMD5Password(password,newSalt); //生成新的加密密码
            userMapper.updateUserInfo(uid,user.getUsername(),newPassword,newSalt);
        }

        //如果用户名和数据库的比对失败说明用户输入了新的用户名
        if(!oldUserInfo.getUsername().equals(user.getUsername())){
            if(userMapper.findByUsername(user.getUsername()) != null){
                throw new UsernameDuplicatedException();
            }
            userMapper.updateUserInfo(uid,user.getUsername(),oldPassword,salt);
        }
    }

    @Override
    public void deleteUser(Integer uid) {
        if(userMapper.findByUid(uid) == null){
            throw new UserNotFoundException();
        }

        Integer rows = userMapper.deleteUser(uid);
        if(rows != 1){
            throw new DeleteUserException();
        }

    }

    private String getMD5Password(String password, String salt){
        //md5加密算法方法的调用(进行三次)
        for(int i=0;i<3;i++){
            password = DigestUtils.md5DigestAsHex((salt+password+salt).getBytes()).toUpperCase();
        }
        //返回加密之后的密码
        return password;
    }
}
