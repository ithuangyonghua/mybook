package com.ithuangyonghua.dao.impl;

import com.ithuangyonghua.bean.OrderItem;
import com.ithuangyonghua.dao.BaseDao;
import com.ithuangyonghua.dao.OrderItemDao;

public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item(`name`,`count`,`price`,`total_price`,`order_id`) values(?,?,?,?,?)";
        return update(sql, orderItem.getName(), orderItem.getCount(), orderItem.getPrice(), orderItem.getTotalPrice(), orderItem.getOrderId());
    }
}
