package com.ithuangyonghua.web;

import com.ithuangyonghua.bean.BookEntity;
import com.ithuangyonghua.bean.Page;
import com.ithuangyonghua.service.BookService;
import com.ithuangyonghua.service.impl.BookServiceImpl;
import com.ithuangyonghua.utils.Constants;
import com.ithuangyonghua.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientBookServlet extends  BaseServlet {
    private BookService bookService = new BookServiceImpl();
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        int pageNo = WebUtils.parseInt( req.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt( req.getParameter("pageSize"),Constants.PAGE_SIZE);
        Page page = bookService.page(pageNo, pageSize);
        page.setUrl("client/ClientBookServlet?action=page");
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }

    protected void getBookByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        int pageNo = WebUtils.parseInt( req.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt( req.getParameter("pageSize"),Constants.PAGE_SIZE);
        int min = WebUtils.parseInt( req.getParameter("min"),0);
        int max = WebUtils.parseInt( req.getParameter("max"),Integer.MAX_VALUE);
        Page<BookEntity> page = bookService.pageByPrice(pageNo, pageSize,min,max);
        StringBuilder stringBuilder = new StringBuilder("client/ClientBookServlet?action=getBookByPrice");
        if(req.getParameter("min")!=null){
            stringBuilder.append("&min=" + req.getParameter("min"));
        }
        if(req.getParameter("max")!=null){
            stringBuilder.append("&max=" + req.getParameter("max"));
        }
        page.setUrl(stringBuilder.toString());
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }
}
