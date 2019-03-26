package com.recyclebookstore.demo.service;

import com.recyclebookstore.demo.entity.TokenInfo;
import com.recyclebookstore.demo.repository.TokenRepository;
import com.recyclebookstore.demo.service.Impl.TokenManageServiceImpl;
import com.recyclebookstore.demo.vo.ResultTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TokenManageService implements TokenManageServiceImpl{
    @Autowired
    private TokenRepository tokenRepository;

    @Override
    public ResultTemplateVO checkTokenInfo(String token, Long user_id) {
        ResultTemplateVO resultTemplateVO = new ResultTemplateVO();
        List<TokenInfo> tokenInfos = tokenRepository.findByTokenStrAndUserId(token,user_id);
        if(tokenInfos.size() != 1){//没有用户的token信息
            resultTemplateVO.setSuccess(false);
            resultTemplateVO.setCode(1);
        } else if(new Date().after(tokenInfos.get(0).getDeadline())){//token过期了
            tokenRepository.deleteByUserId(user_id);
            resultTemplateVO.setSuccess(false);
            resultTemplateVO.setCode(2);
        } else {
            resultTemplateVO.setSuccess(true);
            resultTemplateVO.setCode(0);
        }
        return resultTemplateVO;
    }
}
