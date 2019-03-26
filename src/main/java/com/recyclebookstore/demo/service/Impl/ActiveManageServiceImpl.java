package com.recyclebookstore.demo.service.Impl;

import com.recyclebookstore.demo.entity.CommentInfo;
import com.recyclebookstore.demo.vo.CommentResponseVO;
import com.recyclebookstore.demo.vo.PublishTalkRequestVO;
import com.recyclebookstore.demo.vo.TalksResponseVO;
import com.recyclebookstore.demo.vo.UserTokenVO;

import java.util.List;

public interface ActiveManageServiceImpl {
    public boolean publishTalk(PublishTalkRequestVO requestVO);
    public List<TalksResponseVO> getNewTalks(Long  user_id);
    public List<TalksResponseVO> getMoreTalks(Long  user_id,Long last_talk_id);
    public boolean doLike (Long user_id,Long talk_id,Long comment_id);
    public boolean comment(Long user_id,String comment_content,Long parent_comment_id,Long talk_id);
    public List<CommentResponseVO> findCommentInfoByTalkIdAndParentCommentId(Long talk_id, Long parent_comment_id);
    public boolean deleteCommentById(Long comment_id);
}
