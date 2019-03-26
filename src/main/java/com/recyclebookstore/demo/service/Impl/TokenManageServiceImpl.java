package com.recyclebookstore.demo.service.Impl;

import com.recyclebookstore.demo.vo.ResultTemplateVO;

public interface TokenManageServiceImpl {
    public ResultTemplateVO checkTokenInfo (String token, Long user_id);
}
