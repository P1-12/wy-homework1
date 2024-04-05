package com.example.wyhomework1.controller;

import com.example.wyhomework1.entity.User;
import com.example.wyhomework1.service.IUserService;
import com.example.wyhomework1.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController extends BaseController{
    @Autowired
    private IUserService userService;

    @RequestMapping("reg")
    public JsonResult<Void> reg(User user){
        userService.reg(user);
        return JsonResult.getResponseResult("注册成功");
    }

    @RequestMapping("login")
    public JsonResult<User> login(User user){
        User result = userService.login(user);
        return JsonResult.getResponseResult("登录成功");
    }

    @RequestMapping("updateUserInfo")
    public JsonResult<Void> uodateUserInfo(Integer uid,User user){
        userService.updateUserInfo(uid,user);
        return JsonResult.getResponseResult("更新用户信息成功");
    }

    @RequestMapping("deleteUser")
    public JsonResult<Void> deleteUser(Integer uid){
        userService.deleteUser(uid);
        return JsonResult.getResponseResult("删除用户成功"); //无异常产生，响应用户200（对应操作成功）
    }
}
