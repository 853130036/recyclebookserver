package com.recyclebookstore.demo.vo;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class  Result_User_informationVO {
    private Long id;
    private Long Phone_num;
    private String user_name;
    private Long recycle_coin;
    private String sex;
    private String birthday;
    private Long love_value;
    private boolean is_vip;
    private String token;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPhone_num() {
        return Phone_num;
    }

    public void setPhone_num(Long phone_num) {
        Phone_num = phone_num;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Long getRecycle_coin() {
        return recycle_coin;
    }

    public void setRecycle_coin(Long recycle_coin) {
        this.recycle_coin = recycle_coin;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday()
    {

        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Long getLove_value() {
        return love_value;
    }

    public void setLove_value(Long love_value) {
        this.love_value = love_value;
    }

    public boolean getIs_vip() {
        return is_vip;
    }

    public void setIs_vip(boolean is_vip) {
        this.is_vip = is_vip;
    }
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
