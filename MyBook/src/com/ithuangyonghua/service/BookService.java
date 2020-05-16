package com.ithuangyonghua.service;

import com.ithuangyonghua.bean.BookEntity;
import com.ithuangyonghua.bean.Page;

import java.util.List;

public interface BookService {
    void addBook(BookEntity bookEntity);
    void deleteBookById(Integer id);
    void updateBookById(BookEntity bookEntity);
    BookEntity QueryBookById(Integer id);
    List<BookEntity> QueryBookAll();

    Page page(Integer pageNo,Integer pageSize);

    Page<BookEntity> pageByPrice(int pageNo, int pageSize, int min, int max);
}
