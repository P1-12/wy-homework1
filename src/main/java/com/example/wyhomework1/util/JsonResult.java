package com.example.wyhomework1.util;

import java.io.Serializable;

public class JsonResult<E> implements Serializable {
    public static final int OK = 200;
    private Integer state;
    //描述信息
    private String message;
    //数据(用泛型表示)
    private E data;

    public JsonResult(Integer state) {
        this.state = state;
    }

    public JsonResult(Integer state, String message) {
        this.state = state;
        this.message = message;
    }

    public JsonResult(Integer state, String message, E data) {
        this.state = state;
        this.message = message;
        this.data = data;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public static <E> JsonResult<E> getResponseResult(){
        return new JsonResult<>(OK,null,null);
    }

    public static <E> JsonResult<E> getResponseResult(Integer state){
        return new JsonResult<>(state,null,null);
    }

    public static <E> JsonResult<E> getResponseResult(String message){
        return new JsonResult<>(OK,message,null);
    }

    public static <E> JsonResult<E> getResponseResult(E data){
        return new JsonResult<>(OK,null,data);
    }

    public static <E> JsonResult<E> getResponseResult(Integer state,String message){
        return new JsonResult<>(state,message,null);
    }

    public static <E> JsonResult<E> getResponseResult(Integer state,String message,E data){
        return new JsonResult<>(state,message,data);
    }
}
