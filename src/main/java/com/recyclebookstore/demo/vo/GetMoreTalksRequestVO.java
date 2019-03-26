package com.recyclebookstore.demo.vo;

public class GetMoreTalksRequestVO extends UserTokenVO{
    private Long last_talk_id;

    public Long getLast_talk_id() {
        return last_talk_id;
    }

    public void setLast_talk_id(Long last_talk_id) {
        this.last_talk_id = last_talk_id;
    }
}
