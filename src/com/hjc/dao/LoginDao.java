package com.hjc.dao;

import com.hjc.pojo.User;

public interface LoginDao {
    //根据用户名和密码获取用户信息
    User checkLoginDao(String uname, String pwd);
    //根据uid获取用户信息
    User checkLoginDao(String uid);
}
