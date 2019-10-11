package com.soft1813.jianshu.factory;

import com.soft1813.jianshu.dao.BookDao;
import com.soft1813.jianshu.dao.UserDao;
import com.soft1813.jianshu.dao.impl.BookDaoimpl;
import com.soft1813.jianshu.dao.impl.UserDaoimpl;

/**
 * @author ty
 * @ClassName DaoFactory
 * @Description TODO
 * @Date 2019/10/10
 * @Version 1.0
 **/
public class DaoFactory {
    public static UserDao getUserDaoInstance(){
        return new UserDaoimpl();
    }

    public static BookDao getBookDaoInstance() { return new BookDaoimpl();}
    }

