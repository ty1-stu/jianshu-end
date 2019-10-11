package com.soft1813.jianshu.dao.impl;

import cn.hutool.db.Entity;
import com.soft1813.jianshu.dao.BookDao;
import com.soft1813.jianshu.dao.UserDao;
import com.soft1813.jianshu.factory.DaoFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class BookDaoimplTest {
    private BookDao bookDao = DaoFactory.getBookDaoInstance();

    @Test
    public void selectAll() throws SQLException {
        List<Entity> entityList = bookDao.findAll();
        entityList.forEach(System.out::println);
    }
}