package com.ithuangyonghua.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 数据库连接工具类
 */
public class DBUtils {
    private  static DruidDataSource dataSource;//德鲁伊数据库
    private  static ThreadLocal<Connection> conns = new ThreadLocal<>();//保存连接

    static{
        Properties properties = new Properties();
        try {
            InputStream resourceAsStream = DBUtils.class.getClassLoader().getResourceAsStream("./jdbc.properties");
            properties.load(resourceAsStream);
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取数据库连接
     * @return
     */
    public static Connection getConnection(){
        Connection conn = conns.get();
        if(conn==null){
            try {
                conn = dataSource.getConnection();
                conns.set(conn);//将conn保存到ThreadLocal
                conn.setAutoCommit(false);//设置手动管理事务
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
    /**
     * 数据库关闭
     */
//    public static void closeConnection(Connection conn){
//
//         if(conn!=null){
//             try {
//                 conn.close();
//             } catch (SQLException e) {
//                 e.printStackTrace();
//             }
//         }
//    }

    /**
     * 提交事务并关闭连接
     */
    public static void commitAndCloseConnection(){
        Connection connection = conns.get();
        if(connection!=null){//说明之前使用过并操作过数据库
            try {
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
        conns.remove();//移除此线程局部变量的值。
    }

    /**
     * 回滚事务并关闭连接
     */
    public static void rollbackAndCloseConnection(){
        Connection connection = conns.get();
        if(connection!=null){//说明之前使用过并操作过数据库
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
        conns.remove();//移除此线程局部变量的值。
    }
}
