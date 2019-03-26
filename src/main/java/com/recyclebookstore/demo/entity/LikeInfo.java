package com.recyclebookstore.demo.entity;

import javax.persistence.*;

@Entity
@Table(name="like_info")
public class LikeInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long like_id;
    private Long user_id;
    private Long talk_id;
    private Long comment_id;

    public Long getLike_id() {
        return like_id;
    }

    public void setLike_id(Long like_id) {
        this.like_id = like_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getTalk_id() {
        return talk_id;
    }

    public void setTalk_id(Long talk_id) {
        this.talk_id = talk_id;
    }

    public Long getComment_id() {
        return comment_id;
    }

    public void setComment_id(Long comment_id) {
        this.comment_id = comment_id;
    }
}
