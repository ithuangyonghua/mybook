package com.ithuangyonghua.web;

import com.ithuangyonghua.bean.UserEntity;
import com.ithuangyonghua.service.UserService;
import com.ithuangyonghua.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    //由于我们的注册密码不能显示出来,所以要用Post请求
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //post乱码
        req.setCharacterEncoding("UTF-8");
        //首先获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String yzm = req.getParameter("yzm");
       //注册流程
       //首先我们要判断验证码是否正确
        if(yzm.equalsIgnoreCase("abcde")){
            //如果正确
            //判断用户名是否存在
            if(userService.existsUsername(username)){
                //如果存在(提示用户名已存在)
                req.setAttribute("msg","用户名已存在");
                System.out.println("用户名["+username+"]已存在");
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            }else{
                //如果不存在
                //执行注册操作,
                 userService.registUser(new UserEntity(null,username,password,email));
                //如果注册成功,跳转到注册成功页面(跳转到注册成功页面间期我们要考虑两个问题(1.网络缓慢,提示是否清除2表单重复提交))
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);
                //如果注册失败,提示注册失败
            }
        }else{
            //如果不正确(提示验证码错误)
            req.setAttribute("msg","验证码错误");
            req.setAttribute("username",username);
            req.setAttribute("email",email);
            System.out.println("验证码[" + yzm + "]错误");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }
    }
}
