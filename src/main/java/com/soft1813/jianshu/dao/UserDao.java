package com.soft1813.jianshu.dao;

import cn.hutool.db.Entity;
import com.soft1813.jianshu.entity.User;

import javax.print.MultiDocPrintService;
import java.sql.SQLException;
import java.util.List;

/**
 * @author ty
 * @ClassName UserDao
 * @Description TODO
 * @Date 2019/10/8
 * @Version 1.0
 **/
public interface UserDao {
    /**
     * 查询所有用户
     * @return List<user>
     * @throws SQLException
     */
   List<Entity> findAll() throws SQLException;
/*
新增用户，返回自增主键

 */
  int insertUser(User user) throws SQLException;
}
