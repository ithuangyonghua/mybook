package com.ithuangyonghua.service;

import com.ithuangyonghua.bean.UserEntity;

public interface UserService {
    /**
     * 注册
     * @param userEntity
     */
    public void registUser(UserEntity userEntity);

    /**
     * 登陆
     * @param userEntity
     * @return
     */
    public UserEntity login(UserEntity userEntity);

    /**
     * 用户名是否存在
     * @param username
     * @return
     */
    public boolean existsUsername(String username);
}
