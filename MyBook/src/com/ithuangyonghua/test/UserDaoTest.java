package com.ithuangyonghua.test;

import com.ithuangyonghua.bean.UserEntity;
import com.ithuangyonghua.dao.UserDao;
import com.ithuangyonghua.dao.impl.UserDaoImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {
    //注意面向接口编程
    UserDao userDao = new UserDaoImpl();

    @Test
    public void queryUserByUserName() {
        String username = "admin";
        UserEntity userEntity = userDao.queryUserByUserName(username);
        System.out.println(userEntity);
    }

    @Test
    public void saveUserEnityt() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("黄永华");
        userEntity.setPassword("123");
        userEntity.setEmail("hyh@163.com");
        int result = userDao.saveUserEnityt(userEntity);
        String str = "保存失败";
        if (result > 0) {
            str = "保存成功";
        }
        System.out.println(str);
    }

    @Test
    public void queryUserByUserNameAndPwd() {
        String username = "admin";
        String password = "password";
        UserEntity userEntity = userDao.queryUserByUserNameAndPwd(username, password);
        System.out.println(userEntity);
    }
}