package com.ithuangyonghua.test;

import com.ithuangyonghua.bean.UserEntity;
import com.ithuangyonghua.service.UserService;
import com.ithuangyonghua.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceImplTest {

    UserService userService = new UserServiceImpl();

    @Test
    public void registUser() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("测试1");
        userEntity.setPassword("123");
        userEntity.setEmail("ceshi@163.com");
        userService.registUser(userEntity);
    }

    @Test
    public void login() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("测试1");
        userEntity.setPassword("123");
        userEntity.setEmail("ceshi@163.com");
        userService.login(userEntity);
    }

    @Test
    public void existsUsername() {
        if (userService.existsUsername("wzg16888")) {
            System.out.println("用户名已存在！");
        } else {
            System.out.println("用户名可用！");
        }
    }
}