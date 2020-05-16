package com.ithuangyonghua.dao.impl;

import com.ithuangyonghua.bean.BookEntity;
import com.ithuangyonghua.dao.BaseDao;
import com.ithuangyonghua.dao.BookDao;

import java.util.List;

public class BookDaoImpl extends BaseDao implements BookDao {
    @Override
    public int addBook(BookEntity bookEntity) {
        String sql = "insert into  t_book(`id`, `name` , `author` , `price` , `sales` , `stock` , `img_path`) values(?,?,?,?,?,?,?)";
        return this.update(sql,bookEntity.getId(),bookEntity.getName(),bookEntity.getAuthor(),bookEntity.getPrice(),bookEntity.getSales(),bookEntity.getStock(),bookEntity.getImgPath());
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql = "delete from t_book where id = ?";
        return this.update(sql,id);
    }

    @Override
    public int updateBookById(BookEntity bookEntity) {
        String sql ="update t_book set name=?,author=?,price=?,sales=?,stock=?,img_path=? where id = ?";
        return this.update(sql,bookEntity.getName(),bookEntity.getAuthor(),bookEntity.getPrice(),bookEntity.getSales(),bookEntity.getStock(),bookEntity.getImgPath(),bookEntity.getId());
    }

    @Override
    public BookEntity QueryBookById(Integer id) {
        String sql = "select `id` , `name` , `author` , `price` , `sales` , `stock` , `img_path` imgPath from t_book where id = ?";
        return this.queryForOne(BookEntity.class,sql,id);
    }

    @Override
    public List<BookEntity> QueryBookAll() {
        String sql = "select `id` , `name` , `author` , `price` , `sales` , `stock` , `img_path` imgPath from t_book";
        return this.queryForList(BookEntity.class,sql);

    }

    @Override
    public int pageCount() {
        String sql="select count(*) from t_book";
        Number pageCount = this.queryForSingleValue(sql);
        return pageCount.intValue();
    }

    @Override
    public List<BookEntity> queryBookByPage(int pageNo, int pageSize) {
        String sql="select `id` , `name` , `author` , `price` , `sales` , `stock` , `img_path` imgPath from t_book limit ?,?";
        return this.queryForList(BookEntity.class,sql,pageNo,pageSize);
    }

    @Override
    public int pageCountByPrice(int min, int max) {
        String sql="select count(*) from t_book where  price between ? and ?";
        Number pageCount = this.queryForSingleValue(sql,min,max);
        return pageCount.intValue();
    }

    @Override
    public List<BookEntity> queryBookByPrice(int begin, int pageSize, int min, int max) {
        String sql="select `id` , `name` , `author` , `price` , `sales` , `stock` , `img_path` imgPath from t_book where price between ? and ? order by price  limit ?,?";
        return this.queryForList(BookEntity.class,sql,min,max,begin,pageSize);
    }
}