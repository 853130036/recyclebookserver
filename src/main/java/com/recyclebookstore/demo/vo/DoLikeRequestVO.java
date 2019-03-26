package com.recyclebookstore.demo.vo;

public class DoLikeRequestVO extends UserTokenVO{
    private Long comment_id;

    private Long talk_id;

    public Long getComment_id() {
        return comment_id;
    }

    public void setComment_id(Long comment_id) {
        this.comment_id = comment_id;
    }

    public Long getTalk_id() {
        return talk_id;
    }

    public void setTalk_id(Long talk_id) {
        this.talk_id = talk_id;
    }
}
