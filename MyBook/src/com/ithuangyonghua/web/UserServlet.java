package com.ithuangyonghua.web;

import com.ithuangyonghua.bean.UserEntity;
import com.ithuangyonghua.service.UserService;
import com.ithuangyonghua.service.impl.UserServiceImpl;
import com.ithuangyonghua.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 用户模块
 */
public class UserServlet extends BaseServlet {

    private UserService userService = new UserServiceImpl();
    /**
     * 登陆
     * @param req
     * @param resp
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //首先获取参数
        String username = req.getParameter("username");
        String password =  req.getParameter("password");
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(username);
        userEntity.setPassword(password);
        UserEntity loginResult = userService.login(userEntity);
        if(loginResult!=null){
            req.getSession().setAttribute("user",loginResult);
            //登陆成功
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }else{
            //登陆失败
            req.setAttribute("msg","用户名或密码错误");
            req.setAttribute("username",username);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }
    }

    /**
     * 注册
     * @param req
     * @param resp
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException{
        //post乱码
        req.setCharacterEncoding("UTF-8");
        //首先获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String yzm = req.getParameter("yzm");
        UserEntity userEntity = WebUtils.copyParamToBean(new UserEntity(), req.getParameterMap());
        System.out.println("工具类" + userEntity);
        //获取验证码
        String kaptcha_session_key = (String) req.getSession().getAttribute("KAPTCHA_SESSION_KEY");
        req.getSession().removeAttribute("KAPTCHA_SESSION_KEY");

        if(yzm.equalsIgnoreCase(kaptcha_session_key)&&kaptcha_session_key!=null){
            if(userService.existsUsername(username)){
                req.setAttribute("msg","用户名已存在");
                System.out.println("用户名["+username+"]已存在");
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            }else{
                userService.registUser(new UserEntity(null,username,password,email));
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);
            }
        }else{
            req.setAttribute("msg","验证码错误");
            req.setAttribute("username",username);
            req.setAttribute("email",email);
            System.out.println("验证码[" + yzm + "]错误");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }
    }

    /**
     * 注销
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void logout(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException{
        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath() );
    }

}
