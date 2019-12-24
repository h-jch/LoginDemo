package com.hjc.dao;

import com.hjc.pojo.User;

public interface LoginDao {
    User checkLoginDao(String uname, String pwd);
}
