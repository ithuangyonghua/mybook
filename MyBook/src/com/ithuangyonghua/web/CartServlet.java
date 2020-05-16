package com.ithuangyonghua.web;

import com.ithuangyonghua.bean.BookEntity;
import com.ithuangyonghua.bean.Cart;
import com.ithuangyonghua.bean.CartItem;
import com.ithuangyonghua.service.BookService;
import com.ithuangyonghua.service.impl.BookServiceImpl;
import com.ithuangyonghua.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 购物车模块
 */
public class CartServlet extends BaseServlet {

    private BookService bookService = new BookServiceImpl();

    /**
     * 添加到购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //商品ID
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        BookEntity bookEntity = bookService.QueryBookById(id);
        //将BookEnity转换为CartItem
        CartItem cartItem =  new CartItem(bookEntity.getId(),bookEntity.getName(),1,bookEntity.getPrice(),bookEntity.getPrice());
        //创建Cart
//        Cart cart = new Cart();
        Cart cart = (Cart) req.getSession().getAttribute("cartItem");
        if(cart == null){
            cart = new Cart();
            req.getSession().setAttribute("cartItem",cart);
        }
        cart.addItem(cartItem);
        req.getSession().setAttribute("lastName",cartItem.getName());
        System.out.println(cart);
        //重定向到首页
//        resp.sendRedirect(req.getContextPath());
        resp.sendRedirect(req.getHeader("Referer"));
}

    /**
     * 删除购物车某条记录
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         //
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        Cart cart = (Cart) req.getSession().getAttribute("cartItem");
        if(cart !=null){
            cart.deleteItem(id);
        }
        resp.sendRedirect(req.getHeader("Referer"));
    }

    /**
     * 清空购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cartItem");
        if(cart !=null){
            cart.clear();
        }
        resp.sendRedirect(req.getHeader("Referer"));
    }

    /**
     * 修改商品数量
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取数量和商品id
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        int count = WebUtils.parseInt(req.getParameter("count"), 1);
        Cart cart = (Cart) req.getSession().getAttribute("cartItem");
        if(cart !=null){
            cart.updateCount(id,count);
        }
        resp.sendRedirect(req.getHeader("Referer"));
    }


}
