package com.ithuangyonghua.dao.impl;

import com.ithuangyonghua.bean.Order;
import com.ithuangyonghua.dao.BaseDao;
import com.ithuangyonghua.dao.OrderDao;

public class OrderDaoImpl extends BaseDao implements OrderDao {

    @Override
    public int saveOrader(Order order) {
        String sql = "insert into t_order(`order_id`,`create_time`,`price`,`status`,`user_id`) values(?,?,?,?,?)";
        return this.update(sql,order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());
    }
}
