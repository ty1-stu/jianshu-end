package com.soft1813.jianshu.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.soft1813.jianshu.dao.UserDao;
import com.soft1813.jianshu.entity.User;

import java.sql.SQLException;
import java.util.List;

/**
 * @author ty
 * @ClassName UserDaoimpl
 * @Description TODO
 * @Date 2019/10/8
 * @Version 1.0
 **/
public class UserDaoimpl implements UserDao {

    @Override
    public List<Entity> findAll() throws SQLException {
        return Db.use().query("SELECT*FROM t_user ORDER BY id DESC");
    }

    @Override
    public int insertUser(User user) throws SQLException {
        long id = Db.use().insertForGeneratedKey(
                Entity.create("t_user")
                        .set("account", user.getAccount())
                        .set("password", user.getPassword())
                        .set("nickname", user.getNickname())
                        .set("avatar", user.getAvatar())
                        .set("address", user.getAddress())
                        .set("join_date",user.getJoinDate())
                        .set("description", user.getDescription())
        );
        return (int) id;
    }

    @Override
    public int deleteUserById(int id) throws SQLException {
        return Db.use().del(
                Entity.create("t_user").set("id",id)
        );
    }
}
