package com.recyclebookstore.demo.vo;

import java.util.Date;

public class TalksResponseVO {
    private String title;
    private String content;
    private Long user_id;
    private String user_name;
    private String photo_url;
    private Date talk_datetime;
    private Long talk_id;
    private Long comments_num;
    private Long likes_num;
    private boolean like;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public Date getTalk_datetime() {
        return talk_datetime;
    }

    public void setTalk_datetime(Date talk_datetime) {
        this.talk_datetime = talk_datetime;
    }

    public Long getTalk_id() {
        return talk_id;
    }

    public void setTalk_id(Long talk_id) {
        this.talk_id = talk_id;
    }

    public Long getComments_num() {
        return comments_num;
    }

    public void setComments_num(Long comments_num) {
        this.comments_num = comments_num;
    }

    public Long getLikes_num() {
        return likes_num;
    }

    public void setLikes_num(Long likes_num) {
        this.likes_num = likes_num;
    }

    public boolean isLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }
}
