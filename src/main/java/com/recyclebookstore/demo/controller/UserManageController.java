package com.recyclebookstore.demo.controller;

import com.recyclebookstore.demo.entity.UserInfo;
import com.recyclebookstore.demo.repository.UserManageRepository;
import com.recyclebookstore.demo.service.Impl.UserManageServiceImpl;
import com.recyclebookstore.demo.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserManageController {

    @Autowired
    UserManageServiceImpl userManageService;

    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResultTemplateVO login(@RequestBody LoginRequestVO loginRequestVO)throws Exception{
        ResultTemplateVO result = new ResultTemplateVO();
        LoginResponseVO loginResponseVO = userManageService.login(loginRequestVO);
        if(loginResponseVO != null)
        {
            result.setData(loginResponseVO);
            result.setSuccess(true);
        }
        else
        {
            result.setSuccess(false);
        }
        return result;
    }

    @RequestMapping(value = "/regist",method = RequestMethod.POST)
    @ResponseBody
    public ResultTemplateVO register(@RequestBody RegisterRequestVO registerRequestVO) throws Exception{
        ResultTemplateVO resultTemplateVO = new ResultTemplateVO();
        Boolean success = userManageService.register(registerRequestVO);
        resultTemplateVO.setSuccess(success);
        return resultTemplateVO;
    }
}
