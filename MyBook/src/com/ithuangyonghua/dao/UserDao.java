package com.ithuangyonghua.dao;

import com.ithuangyonghua.bean.UserEntity;

public interface UserDao  {
     public UserEntity queryUserByUserName(String username);

     public int saveUserEnityt(UserEntity userEntity);

     public UserEntity queryUserByUserNameAndPwd(String username,String password);
}
