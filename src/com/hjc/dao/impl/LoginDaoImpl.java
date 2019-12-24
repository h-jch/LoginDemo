package com.hjc.dao.impl;

import com.hjc.dao.LoginDao;
import com.hjc.pojo.User;

import java.sql.*;

public class LoginDaoImpl implements LoginDao {
    @Override
    public User checkLoginDao(String uname, String pwd) {
        //声明jdbc对象
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        //声明数据存储对象
        User u=null;
        try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取连接对象
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/web_login?useSSL=false&serverTimezone=UTC","kei","123456");
            //创建sql命令
            String sql="select * from t_user where uname=? and pwd=?";
            //创建sql命令对象
            ps=conn.prepareStatement(sql);
            //给占位符赋值
            ps.setString(1, uname);
            ps.setString(2, pwd);
            //执行
            rs=ps.executeQuery();
            //遍历执行结果
            while (rs.next()){
                u=new User();
                u.setUid(rs.getInt("uid"));
                u.setUname(rs.getString("uname"));
                u.setPwd(rs.getNString("pwd"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            //关闭资源
            try {
                rs.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            try {
                ps.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            try {
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        //返回
        return u;
    }
}
