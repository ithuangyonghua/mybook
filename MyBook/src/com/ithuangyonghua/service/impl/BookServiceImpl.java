package com.ithuangyonghua.service.impl;

import com.ithuangyonghua.bean.BookEntity;
import com.ithuangyonghua.bean.Page;
import com.ithuangyonghua.dao.BookDao;
import com.ithuangyonghua.dao.impl.BookDaoImpl;
import com.ithuangyonghua.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    private BookDao bookDao = new BookDaoImpl();

    @Override
    public void addBook(BookEntity bookEntity) {
        bookDao.addBook(bookEntity);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBookById(BookEntity bookEntity) {
        bookDao.updateBookById(bookEntity);
    }

    @Override
    public BookEntity QueryBookById(Integer id) {
        return bookDao.QueryBookById(id);
    }

    @Override
    public List<BookEntity> QueryBookAll() {
        return bookDao.QueryBookAll();
    }

    @Override
    public Page page(Integer pageNo, Integer pageSize) {
        Page<BookEntity> page = new Page<>();
        //设置每页显示数量
        page.setPageSize(pageSize);
        //设置总记录数
        int PageTotalCount = bookDao.pageCount();
        page.setPageTotalCount(PageTotalCount);
        //设置总页码
        int pageCount= PageTotalCount / pageSize;
        if(PageTotalCount%pageSize!=0){
            pageCount+=1;
        }
        page.setPageTotal(pageCount);
        //设置当前页码
        page.setPageNo(pageNo);
        int begin = (page.getPageNo()-1) * pageSize;
        //设置当前页数据
        List<BookEntity> items = bookDao.queryBookByPage(begin, pageSize);
        page.setItems(items);
        return page;
    }

    @Override
    public Page<BookEntity> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<BookEntity> page = new Page<>();
        //设置每页显示数量
        page.setPageSize(pageSize);
        //设置总记录数
        int PageTotalCount = bookDao.pageCountByPrice(min,max);
        page.setPageTotalCount(PageTotalCount);
        //设置总页码
        int pageCount= PageTotalCount / pageSize;
        if(PageTotalCount%pageSize!=0){
            pageCount+=1;
        }
        page.setPageTotal(pageCount);
        //设置当前页码
        page.setPageNo(pageNo);
        int begin = (page.getPageNo()-1) * pageSize;
        //设置当前页数据
        List<BookEntity> items = bookDao.queryBookByPrice(begin, pageSize,min,max);
        page.setItems(items);
        return page;
    }
}
