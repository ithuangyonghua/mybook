package com.ithuangyonghua.web;

import com.ithuangyonghua.bean.Cart;
import com.ithuangyonghua.bean.CartItem;
import com.ithuangyonghua.bean.UserEntity;
import com.ithuangyonghua.service.OrderService;
import com.ithuangyonghua.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrderServlet extends BaseServlet {

    private OrderService orderService = new OrderServiceImpl();

    /**
     * 生成订单
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取购物车
        Cart cart = (Cart) req.getSession().getAttribute("cartItem");
        //获取用户ID
        UserEntity userEntity = (UserEntity) req.getSession().getAttribute("user");
        if (userEntity==null){//未登录
//            resp.sendRedirect(req.getContextPath() + "/pages/user/login.jsp");//跳转到登陆页面
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            return ;
        }
        //创建订单
        String orderId = orderService.createOrder(cart, userEntity.getId());
//        req.setAttribute("orderId",orderId);
//        req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req,resp);
        req.getSession().setAttribute("orderId",orderId);
        resp.sendRedirect(req.getContextPath()+"/pages/cart/checkout.jsp");
    }
}
