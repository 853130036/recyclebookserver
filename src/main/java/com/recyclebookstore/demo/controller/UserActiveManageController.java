package com.recyclebookstore.demo.controller;

import com.recyclebookstore.demo.service.Impl.ActiveManageServiceImpl;
import com.recyclebookstore.demo.service.Impl.TokenManageServiceImpl;
import com.recyclebookstore.demo.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/active")
public class UserActiveManageController {
    @Autowired
    ActiveManageServiceImpl activeManageService;

    @Autowired
    TokenManageServiceImpl tokenManageService;

    @ResponseBody
    @RequestMapping(value = "/talk/publish",method = RequestMethod.POST)
    public ResultTemplateVO publishTalk(@RequestBody PublishTalkRequestVO requestVO){
        ResultTemplateVO resultTemplateVO = new ResultTemplateVO();
        resultTemplateVO=tokenManageService.checkTokenInfo(requestVO.getToken(),requestVO.getUser_id());
        if(resultTemplateVO.isSuccess()){
            resultTemplateVO.setSuccess(activeManageService.publishTalk(requestVO));
        }
        return resultTemplateVO;
    }

    @ResponseBody
    @RequestMapping(value = "/talk/refresh",method = RequestMethod.POST)
    public ResultTemplateVO getNewTalks(@RequestBody UserTokenVO userTokenVO){
        ResultTemplateVO resultTemplateVO = new ResultTemplateVO();

        resultTemplateVO=tokenManageService.checkTokenInfo(userTokenVO.getToken(),userTokenVO.getUser_id());
        if(resultTemplateVO.isSuccess()){
            resultTemplateVO.setData(activeManageService.getNewTalks(userTokenVO.getUser_id()));
            resultTemplateVO.setSuccess(true);
        }
        return resultTemplateVO;
    }

    @ResponseBody
    @RequestMapping(value = "/talk/more",method = RequestMethod.POST)
    public ResultTemplateVO getMoreTalks(@RequestBody GetMoreTalksRequestVO getMoreTalksRequestVO){
        ResultTemplateVO resultTemplateVO = new ResultTemplateVO();

        resultTemplateVO=tokenManageService.checkTokenInfo(getMoreTalksRequestVO.getToken(),getMoreTalksRequestVO.getUser_id());
        if(resultTemplateVO.isSuccess()){
            resultTemplateVO.setData(activeManageService.getMoreTalks(getMoreTalksRequestVO.getUser_id(),getMoreTalksRequestVO.getLast_talk_id()));
            resultTemplateVO.setSuccess(true);
        }
        return resultTemplateVO;
    }

    @ResponseBody
    @RequestMapping(value = "/talk/doLike",method = RequestMethod.POST)
    public ResultTemplateVO doLike(@RequestBody DoLikeRequestVO doLikeRequestVO){
        ResultTemplateVO resultTemplateVO = new ResultTemplateVO();

        resultTemplateVO=tokenManageService.checkTokenInfo(doLikeRequestVO.getToken(),doLikeRequestVO.getUser_id());
        if(resultTemplateVO.isSuccess()){
            resultTemplateVO.setSuccess(activeManageService.doLike(doLikeRequestVO.getUser_id(),doLikeRequestVO.getTalk_id(),doLikeRequestVO.getComment_id()));
        }
        return resultTemplateVO;
    }

    @ResponseBody
    @RequestMapping(value = "/talk/comment",method = RequestMethod.POST)
    public ResultTemplateVO comment(@RequestBody CommentRequestVO commentRequestVO){
        ResultTemplateVO resultTemplateVO = new ResultTemplateVO();

        resultTemplateVO=tokenManageService.checkTokenInfo(commentRequestVO.getToken(),commentRequestVO.getUser_id());
        if(resultTemplateVO.isSuccess()){
            resultTemplateVO.setSuccess(activeManageService.comment(commentRequestVO.getUser_id(),commentRequestVO.getComment_content(),commentRequestVO.getParent_comment_id(),commentRequestVO.getTalk_id()));
        }
        return resultTemplateVO;
    }

    @ResponseBody
    @RequestMapping(value = "/talk/getcomments",method = RequestMethod.POST)
    public ResultTemplateVO getComments(@RequestBody FindCommentRequestVO findCommentRequestVO){
        ResultTemplateVO resultTemplateVO = new ResultTemplateVO();
        resultTemplateVO.setData(activeManageService.findCommentInfoByTalkIdAndParentCommentId(findCommentRequestVO.getTalk_id(),findCommentRequestVO.getParent_comment_id()));
        resultTemplateVO.setSuccess(true);
        return resultTemplateVO;
    }

    @ResponseBody
    @RequestMapping(value = "/talk/deletecomment",method = RequestMethod.POST)
    public ResultTemplateVO deleteComment(@RequestBody DeleteCommentRequestVO deleteCommentRequestVO){
        ResultTemplateVO resultTemplateVO = new ResultTemplateVO();
        resultTemplateVO=tokenManageService.checkTokenInfo(deleteCommentRequestVO.getToken(),deleteCommentRequestVO.getUser_id());
        if(resultTemplateVO.isSuccess()){
            resultTemplateVO.setSuccess(activeManageService.deleteCommentById(deleteCommentRequestVO.getComment_id()));
        }
        return resultTemplateVO;
    }
}
