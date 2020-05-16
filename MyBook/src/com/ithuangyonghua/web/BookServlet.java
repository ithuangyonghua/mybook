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
import java.util.List;

/**
 * 图书模块
 */
public class BookServlet extends BaseServlet {

    private BookService bookService = new BookServiceImpl();
//    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        List<BookEntity> bookEntities = bookService.QueryBookAll();
//        req.setAttribute("bookEntities",bookEntities);
//        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
//    }
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取pageNo
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        pageNo +=1;
        req.setCharacterEncoding("UTF-8");
        BookEntity bookEntity = WebUtils.copyParamToBean(new BookEntity(), req.getParameterMap());
        bookService.addBook(bookEntity);
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo="+pageNo);
    }
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        bookService.deleteBookById(id);
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo="+pageNo);
    }
    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        BookEntity bookEntity = bookService.QueryBookById(id);
        req.setAttribute("bookEntity",bookEntity);
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req,resp);
    }
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        BookEntity bookEntity = WebUtils.copyParamToBean(new BookEntity(), req.getParameterMap());
        bookService.updateBookById(bookEntity);
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo="+pageNo);
    }
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        //获取请求参数
        int pageNo = WebUtils.parseInt( req.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt( req.getParameter("pageSize"),Constants.PAGE_SIZE);

        Page page = bookService.page(pageNo, pageSize);
        page.setUrl("manager/bookServlet?action=page");
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }
}
