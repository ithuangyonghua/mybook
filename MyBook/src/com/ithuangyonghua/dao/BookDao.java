package com.ithuangyonghua.dao;

import com.ithuangyonghua.bean.BookEntity;

import java.util.List;

public interface BookDao {

    int addBook(BookEntity bookEntity);
    int deleteBookById(Integer id);
    int updateBookById(BookEntity bookEntity);
    BookEntity QueryBookById(Integer id);
    List<BookEntity> QueryBookAll();
    //获取总记录
    int pageCount();
    //获取当前页数据
    List<BookEntity> queryBookByPage(int pageNo,int pageSize);

    int pageCountByPrice(int min,int max);

    List<BookEntity> queryBookByPrice(int begin, int pageSize, int min, int max);


}
