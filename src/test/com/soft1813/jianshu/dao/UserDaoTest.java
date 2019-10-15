package com.soft1813.jianshu.dao;

import cn.hutool.db.Entity;
import com.soft1813.jianshu.entity.User;
import com.soft1813.jianshu.factory.DaoFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

public class UserDaoTest {
    private UserDao userDao= DaoFactory.getUserDaoInstance();
    @Test
    public void selectAll() throws SQLException {
        List<Entity> entityList=userDao.findAll();
        entityList.forEach(System.out::println);

    }
    @Test
    public void insertUser()throws  SQLException{
        User user =new User();
        user.setAccount("test");
        user.setPassword("123");
        user.setNickname("测试用户");
        user.setAvatar("https://niit-soft.oss-cn-hangzhou.aliyuncs.com/avatar/12.jpg");
        user.setAddress("江苏南京");
        user.setJoinDate(LocalDate.now());
        user.setDescription("新增一个测试用户");
        int id=userDao.insertUser(user);
        System.out.println(id);
    }
}