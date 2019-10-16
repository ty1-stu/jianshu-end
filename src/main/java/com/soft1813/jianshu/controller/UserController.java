package com.soft1813.jianshu.controller;

import cn.hutool.db.Entity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.soft1813.jianshu.dao.UserDao;
import com.soft1813.jianshu.entity.User;
import com.soft1813.jianshu.factory.DaoFactory;
import com.soft1813.jianshu.utils.ResponseObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.locks.Lock;

/**
 * @author ty
 * @ClassName UserController
 * @Description TODO
 * @Date 2019/10/10
 * @Version 1.0
 **/
@WebServlet(urlPatterns = "/api/users")
public class UserController extends HttpServlet  {
    private UserDao userDao = DaoFactory.getUserDaoInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=utf-8");

        List<Entity> userList =null;

        try {
            userList=userDao.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ResponseObject ro=new ResponseObject();

        ro.setCode(resp.getStatus());
        if(resp.getStatus()==200){
            ro.setMsg("请求成功");
        }else{
            ro.setMsg("请求失败");
        }

        ro.setData(userList);
        Gson gson=new GsonBuilder().create();
        PrintWriter out=resp.getWriter();
        out.print(gson.toJson(ro));
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //请求字符集设置
        req.setCharacterEncoding("UTF-8");
        //接受客户端传递的Json数据，通过缓冲字符流按行读取，存入可变昌字符串中
        BufferedReader reader=req.getReader();
        StringBuilder stringBuilder=new StringBuilder();
        String line=null;
        while ((line=reader.readLine())!=null){
            stringBuilder.append(line);
        }
        System.out.println(stringBuilder.toString());
        //将接受到的客户端Json字符串转换成User对象
        Gson gson=new GsonBuilder().create();
        User user=gson.fromJson(stringBuilder.toString(),User.class);
        //补全日期信息
        user.setJoinDate(LocalDate.now());
        //插入数据库，并返回该行主键
        int id=0;

        try {
            id=DaoFactory.getUserDaoInstance().insertUser(user);
        }catch (SQLException e){
            e.printStackTrace();
        }
        //补全user的id字段信息
        user.setId(id);
        //通过response对象返回json信息
        resp.setContentType("application/json;charset=utf-8");
        int code=resp.getStatus();
        String msg=code==200?"成功":"失败";
        ResponseObject ro=ResponseObject.success(code,msg,user);
        PrintWriter out=resp.getWriter();
        out.print(gson.toJson(ro));
        out.close();

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获得前端传递的id参数
        String id= req.getParameter("id");
        System.out.println(id);
        //受影响的记录行数
        int n=0;
        try {
            //根据id删除用户，返回受影响的记录行数
            n=DaoFactory.getUserDaoInstance().deleteUserById(Integer.parseInt(id));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        int code=resp.getStatus();
        String msg= n==1?"成功":"失败";
        //生产无返回数据的响应对象
        ResponseObject ro=ResponseObject.success(code,msg);
        Gson gson=new GsonBuilder().create();
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out=resp.getWriter();
        out.print(gson.toJson(ro));
        out.close();
    }
}


