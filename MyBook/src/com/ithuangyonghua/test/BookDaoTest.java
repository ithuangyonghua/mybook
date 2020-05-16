package com.ithuangyonghua.test;

import com.ithuangyonghua.bean.BookEntity;
import com.ithuangyonghua.dao.BookDao;
import com.ithuangyonghua.dao.impl.BookDaoImpl;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BookDaoTest {
    BookDao bookDao  = new BookDaoImpl();
    @Test
    public void addBook() {
    }

    @Test
    public void deleteBookById() {
    }

    @Test
    public void updateBookById() {
    }

    @Test
    public void queryBookById() {
    }

    @Test
    public void queryBookAll() {
    }

    @Test
    public void pageCount() {
        //获取总页数
        System.out.println(bookDao.pageCount());
    }

    @Test
    public void queryBookByPage() {
        List<BookEntity> bookEntities = bookDao.queryBookByPage(0, 4);
        for(BookEntity book:bookEntities){
            System.out.println(book);
        }
    }
}