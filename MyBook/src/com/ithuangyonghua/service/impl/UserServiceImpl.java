package com.ithuangyonghua.service.impl;

import com.ithuangyonghua.bean.UserEntity;
import com.ithuangyonghua.dao.UserDao;
import com.ithuangyonghua.dao.impl.UserDaoImpl;
import com.ithuangyonghua.service.UserService;

public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl();

    @Override
    public void registUser(UserEntity userEntity) {
        userDao.saveUserEnityt(userEntity);
    }

    @Override
    public UserEntity login(UserEntity userEntity) {
        return userDao.queryUserByUserNameAndPwd(userEntity.getUsername(),userEntity.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        return userDao.queryUserByUserName(username) != null;
    }
}
