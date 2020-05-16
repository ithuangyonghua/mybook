package com.ithuangyonghua.dao;

import com.ithuangyonghua.utils.DBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {

    //使用DBtuils操作数据库
    private QueryRunner queryRunner = new QueryRunner();

    /**
     * 执行update/delete/insert方法
     * @return
     */
    public int update( String sql, Object ... param)  {
        Connection conn = DBUtils.getConnection();
        try {
            return queryRunner.update(conn,sql,param);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    /**
     * 查询返回单条数据
     * @param type
     * @param sql
     * @param args
     * @param <T>
     * @return
     */
    public <T> T queryForOne(Class<T>  type,String sql,Object ... args){
        Connection conn = DBUtils.getConnection();
        try {
            return queryRunner.query(conn,sql,new BeanHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    /**
     * 返回多条数据
     * @param type
     * @param sql
     * @param args
     * @param <T>
     * @return
     */
    public <T> List<T> queryForList(Class<T>  type,String sql,Object ... args){
        Connection conn = DBUtils.getConnection();
        try {
            return queryRunner.query(conn,sql,new BeanListHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    /**
     * 查询某一列的值
     * @param sql
     * @param args
     * @param <E>
     * @return
     */
    public <E> E queryForSingleValue(String sql,Object ... args){
        Connection conn = DBUtils.getConnection();
        try {
           return  (E)queryRunner.query(conn,sql, (ResultSetHandler<Object>) new ScalarHandler(),args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
