package com.hjc.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class NumServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        //获取文件中的计数器数据
        //获取文件路径
        String path=this.getServletContext().getRealPath("/nums/nums.txt");
        //声明流对象
        FileReader fr=null;
        BufferedReader br=null;
        try {
            fr=new FileReader(path);
            br=new BufferedReader(fr);
            String nums=br.readLine();
            System.out.println(nums);
            this.getServletContext().setAttribute("nums",nums);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void destroy() {
        //获取网页计数器
        int nums=(int) this.getServletContext().getAttribute("nums");
        //获取文件路径
        String path=this.getServletContext().getRealPath("/nums/nums.txt");
        //声明流对象
        BufferedWriter bw=null;
        FileWriter fw=null;
        try {
            fw=new FileWriter(path);
            bw=new BufferedWriter(fw);
            bw.write(nums);
            bw.flush();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
