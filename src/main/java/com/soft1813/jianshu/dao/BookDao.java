package com.soft1813.jianshu.dao;

import cn.hutool.db.Entity;

import java.sql.SQLException;
import java.util.List;

/**
 * @author ty
 * @ClassName BookDao
 * @Description TODO
 * @Date 2019/10/11
 * @Version 1.0
 **/
public interface BookDao {
    /**
     * 查询所有用户
     * @return List<user>
     * @throws SQLException
     */
    List<Entity> findAll() throws SQLException;
}
