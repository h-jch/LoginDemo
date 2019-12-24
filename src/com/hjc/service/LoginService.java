package com.hjc.service;

import com.hjc.pojo.User;

public interface LoginService {
    User checkLoginService(String uname, String pwd);
}
