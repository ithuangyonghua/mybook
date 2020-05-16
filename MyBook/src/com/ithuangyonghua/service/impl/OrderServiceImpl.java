package com.ithuangyonghua.service.impl;

import com.ithuangyonghua.bean.*;
import com.ithuangyonghua.dao.BookDao;
import com.ithuangyonghua.dao.OrderDao;
import com.ithuangyonghua.dao.OrderItemDao;
import com.ithuangyonghua.dao.impl.BookDaoImpl;
import com.ithuangyonghua.dao.impl.OrderDaoImpl;
import com.ithuangyonghua.dao.impl.OrderItemDaoImpl;
import com.ithuangyonghua.service.OrderService;

import java.util.Date;
import java.util.Map;

public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private BookDao bookDao = new BookDaoImpl();

    //创建订单
    @Override
    public String createOrder(Cart cart, Integer userId) {
        //保存订单表
        Order order = new Order(null,new Date(),cart.getTotalPrice(),0,userId);
        String orderId = System.currentTimeMillis() + "" + userId;
        order.setOrderId(orderId);
        orderDao.saveOrader(order);
//        int re =  10/0;
        //保存订单详情表
        for(Map.Entry<Integer,CartItem> item :cart.getItems().entrySet()){
            CartItem cartItem = item.getValue();
            OrderItem orderItem = new OrderItem(null,cartItem.getName(),cartItem.getCount(),cartItem.getPrice(),cartItem.getTotalPrice(),orderId);
            orderItemDao.saveOrderItem(orderItem);
            BookEntity bookEntity = bookDao.QueryBookById(cartItem.getId());//获取图书信息
            //更新库存和销量
            bookEntity.setSales(bookEntity.getSales() + cartItem.getCount());//销量
            bookEntity.setStock(bookEntity.getStock() - cartItem.getCount());//库存
            bookDao.updateBookById(bookEntity);
        }
        //注意我们购买完后,购物车应该被清空
        cart.clear();
        return orderId;
    }
}
