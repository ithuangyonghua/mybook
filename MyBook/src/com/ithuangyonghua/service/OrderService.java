package com.ithuangyonghua.service;

import com.ithuangyonghua.bean.Cart;

public interface OrderService {
    public String createOrder(Cart cart, Integer userId);
}
