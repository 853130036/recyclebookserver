package com.recyclebookstore.demo.service.Impl;

import com.recyclebookstore.demo.entity.UserInfo;
import com.recyclebookstore.demo.vo.Result_User_informationVO;
import com.recyclebookstore.demo.vo.User_informationVO;

public interface User_informationServiceImpl
{
    public Result_User_informationVO getinformation(User_informationVO user_informationVO);

    public String changeinformation(Result_User_informationVO user_informationVO);
}
