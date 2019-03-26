package com.recyclebookstore.demo.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="talk_info")
public class TalkInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long talk_id;
    private String talk_title;
    private String talk_content;
    private Long user_id;
    private Date talk_datetime;

    public Long getTalk_id() {
        return talk_id;
    }

    public void setTalk_id(Long talk_id) {
        this.talk_id = talk_id;
    }

    public String getTalk_title() {
        return talk_title;
    }

    public void setTalk_title(String talk_title) {
        this.talk_title = talk_title;
    }

    public String getTalk_content() {
        return talk_content;
    }

    public void setTalk_content(String talk_content) {
        this.talk_content = talk_content;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Date getTalk_datetime() {
        return talk_datetime;
    }

    public void setTalk_datetime(Date talk_datetime) {
        this.talk_datetime = talk_datetime;
    }
}
