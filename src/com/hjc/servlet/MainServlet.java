package com.hjc.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码格式
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");
        //获取请求信息
        //处理请求信息
        //响应处理结果
        resp.getWriter().write("<html>");
        resp.getWriter().write("<head>");
        resp.getWriter().write("</head>");
        resp.getWriter().write("<body>");
        resp.getWriter().write("<h3>欢迎"+req.getParameter("uname")+"访问此页面</h3>");
        resp.getWriter().write("<hr>");
        resp.getWriter().write("</body>");
        resp.getWriter().write("</html>");
    }
}
