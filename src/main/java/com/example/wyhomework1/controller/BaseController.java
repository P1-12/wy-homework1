package com.example.wyhomework1.controller;

import com.example.wyhomework1.service.ex.*;
import com.example.wyhomework1.util.JsonResult;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.ServletException;

public class BaseController {

    /**
     * 统一处理抛出的异常
     * 1、注解@ExceptionHandler表示捕获应用程序中指定的异常
     * 2、执行过程：如果应用程序中产生了指定的异常，将@ExceptionHandler所标记的方法
     * 的返回值作为响应给前端的内容
     * 3、只要产生了异常，就会将对应的异常传递给当前方法的参数列表
     */
    @ExceptionHandler(ServiceException.class)
    public JsonResult<Void> handleException(Throwable e){
        JsonResult<Void> jsonResult = null;

        if(e instanceof RegException){
            /** 方法一返回状态码
            jsonResult.setState(2001);
            jsonResult.setMessage("注册异常");
             */

            /** 方法二返回状态码 */
            jsonResult = JsonResult.getResponseResult(4001,"用户注册产生未知的错误");
        } else if (e instanceof UsernameDuplicatedException) {
            jsonResult = JsonResult.getResponseResult(4002,"用户名被占用");
        } else if (e instanceof UserNotFoundException) {
            jsonResult = JsonResult.getResponseResult(4003,"用户不存在");
        } else if (e instanceof PasswordErrorException) {
            jsonResult = JsonResult.getResponseResult(4004,"密码错误");
        } else if (e instanceof DeleteUserException) {
            jsonResult = JsonResult.getResponseResult(4005,"用户删除产生未知的错误");
        }
        return jsonResult;
    }
}
