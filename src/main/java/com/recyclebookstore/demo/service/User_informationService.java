package com.recyclebookstore.demo.service;


import com.recyclebookstore.demo.entity.UserInfo;
import com.recyclebookstore.demo.repository.TokenRepository;

import com.recyclebookstore.demo.repository.User_informationRepostitory;
import com.recyclebookstore.demo.service.Impl.User_informationServiceImpl;
import com.recyclebookstore.demo.vo.Result_User_informationVO;
import com.recyclebookstore.demo.vo.User_informationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class User_informationService implements User_informationServiceImpl
{
    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private User_informationRepostitory User_informationRepostitory;


    UserInfo userInfo;
    @Override
    public Result_User_informationVO getinformation(User_informationVO user_informationVO){


        User_informationVO User_informationVO;


        // 通过id查找所有的信息
        Result_User_informationVO result_user_informationVO=new Result_User_informationVO();
        userInfo=User_informationRepostitory.getByUser_id(user_informationVO.getId());

        if(userInfo!=null)
        {



                result_user_informationVO.setId(userInfo.getId());
                result_user_informationVO.setBirthday(userInfo.getBirthday());
                result_user_informationVO.setIs_vip(userInfo.isIs_vip());
                result_user_informationVO.setLove_value(userInfo.getLove_value());
                result_user_informationVO.setPhone_num(userInfo.getPhone_num());
                result_user_informationVO.setRecycle_coin(userInfo.getRecycle_coin());
                result_user_informationVO.setSex(userInfo.getSex());
                result_user_informationVO.setUser_name(userInfo.getUser_name());
                result_user_informationVO.setPassword(userInfo.getUser_password());
                return result_user_informationVO;





        }
        else return null;

    }




    @Override
    public String changeinformation(Result_User_informationVO user_informationVO) {

        String result;


        if (User_informationRepostitory.updateByUser_id(user_informationVO.getPhone_num(), user_informationVO.getUser_name(), user_informationVO.getSex(), user_informationVO.getBirthday(), user_informationVO.getPassword(),user_informationVO.getId()) != 0) {
            result = "success";
            return result;

        } else {
            result = "defalut";
            return result;
        }

    }
}
