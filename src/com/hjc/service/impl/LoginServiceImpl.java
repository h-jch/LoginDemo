package com.hjc.service.impl;

import com.hjc.dao.LoginDao;
import com.hjc.dao.impl.LoginDaoImpl;
import com.hjc.pojo.User;
import com.hjc.service.LoginService;

public class LoginServiceImpl implements LoginService {
    //创建Dao层对象
    LoginDao ld=new LoginDaoImpl();

    //校验用户登录信息
    @Override
    public User checkLoginService(String uname, String pwd) {
        return ld.checkLoginDao(uname, pwd);
    }

    //检验Cookie信息
    @Override
    public User checkLoginService(String uid) {
        return ld.checkLoginDao(uid);
    }
}
