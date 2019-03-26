package com.recyclebookstore.demo.service;

import com.recyclebookstore.demo.entity.CommentInfo;
import com.recyclebookstore.demo.entity.LikeInfo;
import com.recyclebookstore.demo.entity.TalkInfo;
import com.recyclebookstore.demo.entity.UserInfo;
import com.recyclebookstore.demo.repository.CommentRepository;
import com.recyclebookstore.demo.repository.LikeRepository;
import com.recyclebookstore.demo.repository.TalksRepository;
import com.recyclebookstore.demo.repository.UserManageRepository;
import com.recyclebookstore.demo.service.Impl.ActiveManageServiceImpl;
import com.recyclebookstore.demo.vo.CommentResponseVO;
import com.recyclebookstore.demo.vo.PublishTalkRequestVO;
import com.recyclebookstore.demo.vo.TalksResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ActiveManageService implements ActiveManageServiceImpl {

    @Autowired
    TalksRepository talksRepository;

    @Autowired
    UserManageRepository userManageRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    LikeRepository likeRepository;

    @Override
    public boolean publishTalk(PublishTalkRequestVO requestVO) {
        TalkInfo talkInfo = new TalkInfo();
        talkInfo.setTalk_title(requestVO.getTalk_title());
        talkInfo.setTalk_content(requestVO.getTalk_content());
        talkInfo.setUser_id(requestVO.getUser_id());
        talkInfo.setTalk_datetime(new Date());
        if(talksRepository.save(talkInfo)==null){
            return false;
        } else {
            return true;
        }
    }

    @Override
    public List<TalksResponseVO> getNewTalks(Long  user_id) {
        List<TalkInfo> talkInfos = talksRepository.GetNewTalks();
        Collections.reverse(talkInfos);
        List<TalksResponseVO> talksResponseVOS = new ArrayList<>();
        for (TalkInfo t: talkInfos) {
            TalksResponseVO talksResponseVO = new TalksResponseVO();
            talksResponseVO.setTitle(t.getTalk_title());
            talksResponseVO.setContent(t.getTalk_content());
            talksResponseVO.setUser_id(t.getUser_id());

            Optional<UserInfo> userInfo = userManageRepository.findById(t.getUser_id());
            talksResponseVO.setUser_name(userInfo.get().getUser_name());
            talksResponseVO.setPhoto_url(userInfo.get().getProfile_photo_url());

            talksResponseVO.setTalk_datetime(t.getTalk_datetime());
            talksResponseVO.setTalk_id(t.getTalk_id());
            talksResponseVO.setComments_num(commentRepository.CountCommentByTalkIdAndParentCommentId(t.getTalk_id(),new Long(0)));
            talksResponseVO.setLikes_num(likeRepository.CountLikeByTalkIdAndCommentId(t.getTalk_id(),0l));

            if(likeRepository.CountLikeByUserIdAndTalkId(user_id,t.getTalk_id(),0l)==0){
                talksResponseVO.setLike(false);
            } else {
                talksResponseVO.setLike(true);
            }
            talksResponseVOS.add(talksResponseVO);
        }
        return talksResponseVOS;
    }

    @Override
    public List<TalksResponseVO> getMoreTalks(Long user_id, Long last_talk_id) {
        List<TalkInfo> talkInfos = talksRepository.GetMoreTalks(last_talk_id);
        Collections.reverse(talkInfos);
        List<TalksResponseVO> talksResponseVOS = new ArrayList<>();
        for (TalkInfo t: talkInfos) {
            TalksResponseVO talksResponseVO = new TalksResponseVO();
            talksResponseVO.setTitle(t.getTalk_title());
            talksResponseVO.setContent(t.getTalk_content());
            talksResponseVO.setUser_id(t.getUser_id());

            Optional<UserInfo> userInfo = userManageRepository.findById(t.getUser_id());
            talksResponseVO.setUser_name(userInfo.get().getUser_name());
            talksResponseVO.setPhoto_url(userInfo.get().getProfile_photo_url());

            talksResponseVO.setTalk_datetime(t.getTalk_datetime());
            talksResponseVO.setTalk_id(t.getTalk_id());
            talksResponseVO.setComments_num(commentRepository.CountCommentByTalkIdAndParentCommentId(t.getTalk_id(),new Long(0)));
            talksResponseVO.setLikes_num(likeRepository.CountLikeByTalkIdAndCommentId(t.getTalk_id(),0l));

            if(likeRepository.CountLikeByUserIdAndTalkId(user_id,t.getTalk_id(),0l)==0){
                talksResponseVO.setLike(false);
            } else {
                talksResponseVO.setLike(true);
            }
            talksResponseVOS.add(talksResponseVO);
        }
        return talksResponseVOS;
    }

    @Override
    public boolean doLike(Long user_id, Long talk_id,Long comment_id) {
        talk_id=talk_id==null?0l:talk_id;
        comment_id=comment_id==null?0l:comment_id;
        if(likeRepository.CountLikeByUserIdAndTalkId(user_id,talk_id,comment_id)==0){//未点过赞 则写入先赞数据
            LikeInfo likeInfo = new LikeInfo();
            likeInfo.setTalk_id(talk_id);
            likeInfo.setUser_id(user_id);
            likeInfo.setComment_id(comment_id);
            if(likeRepository.save(likeInfo)==null){//点赞写入失败返回null
                return false;
            }
        } else {
            if(likeRepository.DeleteLikeByUserIdAndTalkId(user_id,talk_id,comment_id)==0){//已经点过赞 则取消点赞 即删除数据
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean comment(Long user_id, String comment_content, Long parent_comment_id, Long talk_id) {
        CommentInfo commentInfo = new CommentInfo();
        commentInfo.setUser_id(user_id);
        commentInfo.setParent_comment_id(parent_comment_id);
        commentInfo.setTalk_id(talk_id);
        commentInfo.setComment_content(comment_content);
        commentInfo.setComment_datetime(new Date());
        if(commentRepository.save(commentInfo)==null){
            return false;
        } else {
            return true;
        }
    }

    @Override
    public List<CommentResponseVO> findCommentInfoByTalkIdAndParentCommentId(Long talk_id, Long parent_comment_id) {
        List<CommentResponseVO> commentResponseVOS = new ArrayList<>();
        List<CommentInfo> commentInfos = commentRepository.findCommentInfoByTalkIdAndParentCommentId(talk_id,parent_comment_id);
        for(CommentInfo t :commentInfos){
            CommentResponseVO commentResponseVO = new CommentResponseVO();
            Optional<UserInfo> userInfo = userManageRepository.findById(t.getUser_id());

            commentResponseVO.setComments_num(commentRepository.CountCommentByTalkIdAndParentCommentId(talk_id,t.getComment_id()));
            commentResponseVO.setComment_id(t.getComment_id());
            commentResponseVO.setComment_content(t.getComment_content());
            commentResponseVO.setIs_vip(userInfo.get().isIs_vip());
            commentResponseVO.setLikes_num(likeRepository.CountLikeByTalkIdAndCommentId(0l,t.getComment_id()));
            commentResponseVO.setName(userInfo.get().getUser_name());
            commentResponseVO.setPhoto_url(userInfo.get().getProfile_photo_url());
            commentResponseVO.setUser_id(t.getUser_id());
            commentResponseVO.setComment_datetime(t.getComment_datetime());

            commentResponseVOS.add(commentResponseVO);
        }
        return commentResponseVOS;
    }

    @Override
    public boolean deleteCommentById(Long comment_id) {
        if(commentRepository.deleteCommentInfoById(comment_id)==1){
            return true;
        } else {
            return false;
        }
    }
}
