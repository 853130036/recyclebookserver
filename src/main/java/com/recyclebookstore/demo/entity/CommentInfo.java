package com.recyclebookstore.demo.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="comment_info")
public class CommentInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comment_id;

    private String comment_content;
    private Long user_id;
    private Date comment_datetime;
    private Long parent_comment_id;
    private Long talk_id;

    public Long getComment_id() {
        return comment_id;
    }

    public void setComment_id(Long comment_id) {
        this.comment_id = comment_id;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Date getComment_datetime() {
        return comment_datetime;
    }

    public void setComment_datetime(Date comment_datetime) {
        this.comment_datetime = comment_datetime;
    }

    public Long getParent_comment_id() {
        return parent_comment_id;
    }

    public void setParent_comment_id(Long parent_comment_id) {
        this.parent_comment_id = parent_comment_id;
    }

    public Long getTalk_id() {
        return talk_id;
    }

    public void setTalk_id(Long talk_id) {
        this.talk_id = talk_id;
    }

}
