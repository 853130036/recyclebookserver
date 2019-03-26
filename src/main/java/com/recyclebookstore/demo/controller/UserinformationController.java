package com.recyclebookstore.demo.controller;

import com.recyclebookstore.demo.service.Impl.ActiveManageServiceImpl;
import com.recyclebookstore.demo.service.Impl.TokenManageServiceImpl;
import com.recyclebookstore.demo.service.User_informationService;
import com.recyclebookstore.demo.vo.ResultTemplateVO;
import com.recyclebookstore.demo.vo.Result_User_informationVO;
import com.recyclebookstore.demo.vo.User_informationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.recyclebookstore.demo.entity.UserInfo;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserinformationController
{
    @Autowired
    ActiveManageServiceImpl activeManageService;

    @Autowired
    TokenManageServiceImpl tokenManageService;
    @Autowired
    User_informationService user_informationService;

@ResponseBody
@RequestMapping(value = "/information",method = RequestMethod.POST)
public Result_User_informationVO getinformation(@RequestBody User_informationVO user_information)
{
    Result_User_informationVO result_user_informationVO=new Result_User_informationVO();
    /*ResultTemplateVO resultTemplateVO = new ResultTemplateVO();
    resultTemplateVO=tokenManageService.checkTokenInfo(user_information.getToken(),user_information.getId());
    if(resultTemplateVO.isSuccess()){
        result_user_informationVO=user_informationService.getinformation(user_information);
        return result_user_informationVO;
    }
   else  return null;*/
    result_user_informationVO=user_informationService.getinformation(user_information);
    return result_user_informationVO;

}
    @ResponseBody
    @RequestMapping(value = "/changeinformation",method = RequestMethod.POST)
    public String changeinformation(@RequestBody Result_User_informationVO result_user_informationVO)
    {
        /*
        ResultTemplateVO resultTemplateVO = new ResultTemplateVO();
        resultTemplateVO=tokenManageService.checkTokenInfo(result_user_informationVO.getToken(),result_user_informationVO.getId());
        if(resultTemplateVO.isSuccess()){
            user_informationService.changeinformation(result_user_informationVO);
            return "success";
        }
      else return "default";*/
        user_informationService.changeinformation(result_user_informationVO);
        return "success";
    }

}
