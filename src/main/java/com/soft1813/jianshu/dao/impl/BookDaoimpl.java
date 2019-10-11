package com.soft1813.jianshu.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.soft1813.jianshu.dao.BookDao;

import java.sql.SQLException;
import java.util.List;

/**
 * @author ty
 * @ClassName BookDaoimpl
 * @Description TODO
 * @Date 2019/10/11
 * @Version 1.0
 **/
public class BookDaoimpl implements BookDao {
    @Override
    public List<Entity> findAll() throws SQLException {
        return Db.use().query("SELECT*FROM book ORDER BY id DESC");
    }
}
