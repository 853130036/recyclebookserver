package com.recyclebookstore.demo.service;

import com.recyclebookstore.demo.entity.TokenInfo;
import com.recyclebookstore.demo.entity.UserInfo;
import com.recyclebookstore.demo.repository.TokenRepository;
import com.recyclebookstore.demo.repository.UserManageRepository;
import com.recyclebookstore.demo.service.Impl.UserManageServiceImpl;
import com.recyclebookstore.demo.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserManageService implements UserManageServiceImpl {

    @Autowired
    private UserManageRepository userManageRepository;

    @Autowired
    private TokenRepository tokenRepository;

    @Override
    public LoginResponseVO login(LoginRequestVO loginRequestVO) {
        LoginResponseVO loginResponseVO = new LoginResponseVO();
        List<UserInfo> userInfos = new ArrayList<>();
        //验证账号密码
        userInfos = userManageRepository.login(loginRequestVO.getUserName(),loginRequestVO.getPassword());
        if(userInfos.size()==1) {
            //检查用户token 若存在 则删除后重新生成
            List<TokenInfo> tokenInfos = tokenRepository.findByUserId(userInfos.get(0).getUser_id());
            if(tokenInfos.size()!=0){
                tokenRepository.deleteByUserId(tokenInfos.get(0).getUser_id());
            }

            TokenInfo tokenInfo = new TokenInfo();
            //生成token
            tokenInfo.setToken_str(UUID.randomUUID().toString().replace("-", ""));
            //把日期往后增加一天.正数往后推,负数往前推
            Calendar calendar   =   new   GregorianCalendar();
            Date date = new Date();
            calendar.setTime(date);
            calendar.add(Calendar.DATE,1);
            date=calendar.getTime();
            tokenInfo.setDeadline(date);
            tokenInfo.setUser_id(userInfos.get(0).getUser_id());
            tokenInfo=tokenRepository.save(tokenInfo);
            //token生成成功则不为null 返回登陆获得的数据
            if(tokenInfo!=null){
                loginResponseVO.setUser_id(userInfos.get(0).getUser_id());
                loginResponseVO.setToken(tokenInfo.getToken_str());
                loginResponseVO.setUser_name(userInfos.get(0).getUser_name());
                loginResponseVO.setSex(userInfos.get(0).getSex());
                loginResponseVO.setProfile_photo_url(userInfos.get(0).getProfile_photo_url());
                loginResponseVO.setIs_vip(userInfos.get(0).isIs_vip());
                loginResponseVO.setEmpirical_value(userInfos.get(0).getEmpirical_value());
                return loginResponseVO;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    @Override
    public boolean register(RegisterRequestVO registerRequestVO) {
        UserInfo userInfo = new UserInfo();

        userInfo.setProfile_photo_url(registerRequestVO.getProfilePhotoUrl());
        userInfo.setUser_password(registerRequestVO.getUserPassword());
        userInfo.setUser_name(registerRequestVO.getUserName());
        userInfo.setSex(registerRequestVO.getSex());
        userInfo.setPhone_num(Long.parseLong(registerRequestVO.getPhoneNum()));
        userInfo.setRegist_date(new Date());
        userInfo.setRecycle_coin(0L);
        userInfo.setEmpirical_value(0L);
        userInfo.setIs_vip(false);
        userInfo.setLove_value(0L);

        UserInfo backInfo = userManageRepository.save(userInfo);
        if (backInfo==userInfo)
            return true;
        else
            return false;
    }

}
