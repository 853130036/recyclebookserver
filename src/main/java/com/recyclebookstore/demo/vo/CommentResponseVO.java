package com.recyclebookstore.demo.vo;

import java.util.Date;

public class CommentResponseVO {
    private Long user_id;
    private String photo_url;
    private String name;
    private boolean is_vip;
    private String comment_content;
    private Long comment_id;
    private Long comments_num;
    private Long likes_num;
    private Date comment_datetime;

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIs_vip() {
        return is_vip;
    }

    public void setIs_vip(boolean is_vip) {
        this.is_vip = is_vip;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

    public Long getComment_id() {
        return comment_id;
    }

    public void setComment_id(Long comment_id) {
        this.comment_id = comment_id;
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

    public Date getComment_datetime() {
        return comment_datetime;
    }

    public void setComment_datetime(Date comment_datetime) {
        this.comment_datetime = comment_datetime;
    }
}
