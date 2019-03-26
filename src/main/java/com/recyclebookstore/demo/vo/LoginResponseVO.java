package com.recyclebookstore.demo.vo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class LoginResponseVO extends UserTokenVO{

    private String user_name;

    private String sex;

    private String profile_photo_url;

    private boolean is_vip;

    private Long empirical_value;


    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
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
