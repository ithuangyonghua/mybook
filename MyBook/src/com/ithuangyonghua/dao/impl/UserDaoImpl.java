package com.ithuangyonghua.dao.impl;

import com.ithuangyonghua.bean.UserEntity;
import com.ithuangyonghua.dao.BaseDao;
import com.ithuangyonghua.dao.UserDao;

public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public UserEntity queryUserByUserName(String username) {
        String sql = "select * from t_user where username = ?";
        UserEntity userEntity = this.queryForOne(UserEntity.class, sql, username);
        return userEntity;
    }

    @Override
    public int saveUserEnityt(UserEntity userEntity) {
        String sql = "insert into t_user(username,password,email) values (?,?,?)";
        int result = this.update(sql, userEntity.getUsername(), userEntity.getPassword(), userEntity.getEmail());
        return result;
    }

    @Override
    public UserEntity queryUserByUserNameAndPwd(String username, String password) {
        String sql = "select * from t_user where username = ? and password = ?";
        UserEntity userEntity = this.queryForOne(UserEntity.class, sql, username, password);
        return userEntity;
    }
}
