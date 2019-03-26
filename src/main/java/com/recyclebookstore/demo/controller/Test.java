package com.recyclebookstore.demo.controller;

import com.recyclebookstore.demo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/test")
public class Test {
    @Autowired
    CommentRepository commentRepository;

    @RequestMapping(value = "/test1",method = RequestMethod.POST)
    @ResponseBody
    public Long register() throws Exception{
        return /*commentRepository.CountCommentByTalkIdAndParentCommentId(new Long(3));*/null;
}
}
