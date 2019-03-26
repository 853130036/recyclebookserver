package com.recyclebookstore.demo.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="user_info")
public class UserInfo {
    //表示主键
    @Id
    //主键生成策略
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column：如果字段名与列名相同，则可以省略
    private Long user_id;

    private  Long phone_num;

    private String user_name;

    private String user_password;

    private Long recycle_coin;

    private String sex;

    private String profile_photo_url;

    private String  birthday;

    //Date 导入包 记住是util
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date regist_date;

    private Long love_value;

    private boolean is_vip;

    private Long empirical_value;

    public Long getId() {
        return user_id;
    }

    public void setId(Long user_id) {
        this.user_id = user_id;
    }

    public Long getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(Long phone_num) {
        this.phone_num = phone_num;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
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

    public String getProfile_photo_url() {
        return profile_photo_url;
    }

    public void setProfile_photo_url(String profile_photo_url) {
        this.profile_photo_url = profile_photo_url;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Date getRegist_date() {
        return regist_date;
    }

    public void setRegist_date(Date regist_date) {
        this.regist_date = regist_date;
    }

    public Long getLove_value() {
        return love_value;
    }

    public void setLove_value(Long love_value) {
        this.love_value = love_value;
    }

    public boolean isIs_vip() {
        return is_vip;
    }

    public void setIs_vip(boolean is_vip) {
        this.is_vip = is_vip;
    }

    public Long getEmpirical_value() {
        return empirical_value;
    }

    public void setEmpirical_value(Long empirical_value) {
        this.empirical_value = empirical_value;
    }
}