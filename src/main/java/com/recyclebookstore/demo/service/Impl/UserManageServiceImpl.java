package com.recyclebookstore.demo.service.Impl;

import com.recyclebookstore.demo.vo.*;

public interface UserManageServiceImpl {

    public LoginResponseVO login(LoginRequestVO loginRequestVO);

    public boolean register(RegisterRequestVO registerRequestVO);
}
