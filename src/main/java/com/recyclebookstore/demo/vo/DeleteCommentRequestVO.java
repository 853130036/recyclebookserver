package com.recyclebookstore.demo.vo;

public class DeleteCommentRequestVO extends UserTokenVO {
    private Long comment_id;

    public Long getComment_id() {
        return comment_id;
    }

    public void setComment_id(Long comment_id) {
        this.comment_id = comment_id;
    }
}
