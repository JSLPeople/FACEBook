package com.jsu.service;

import com.jsu.pojo.Cart;

public interface OrderService {
    public String createOrder(Cart cart,Integer userId);
}

