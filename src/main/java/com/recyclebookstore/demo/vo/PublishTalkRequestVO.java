package com.recyclebookstore.demo.vo;

public class PublishTalkRequestVO extends UserTokenVO{
    private String talk_title;
    private String talk_content;

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
}
