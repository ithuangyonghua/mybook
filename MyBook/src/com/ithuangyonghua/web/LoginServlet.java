package com.ithuangyonghua.web;

import com.ithuangyonghua.bean.UserEntity;
import com.ithuangyonghua.service.UserService;
import com.ithuangyonghua.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //首先获取参数
        String username = req.getParameter("username");
        String password =  req.getParameter("password");
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(username);
        userEntity.setPassword(password);
        UserEntity loginResult = userService.login(userEntity);
        if(loginResult!=null){
            //登陆成功
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }else{
            //登陆失败
            req.setAttribute("msg","用户名或密码错误");
            req.setAttribute("username",username);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }

    }
}
