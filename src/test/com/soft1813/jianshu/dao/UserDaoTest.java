package com.soft1813.jianshu.dao;

import cn.hutool.db.Entity;
import com.soft1813.jianshu.factory.DaoFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class UserDaoTest {
    private UserDao userDao= DaoFactory.getUserDaoInstance();
    @Test
    public void selectAll() throws SQLException {
        List<Entity> entityList=userDao.findAll();
        entityList.forEach(System.out::println);

    }
    public  void  deletUserById(){
    }
}