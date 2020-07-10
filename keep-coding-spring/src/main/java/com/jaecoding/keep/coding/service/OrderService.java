package com.jaecoding.keep.coding.service;

import com.jaecoding.keep.coding.domian.Order;

import java.util.Map;

/**
 * OrderService
 *
 * @author pengwenjie3
 * @date 2020/7/9
 * @since 1.8
 */
public interface OrderService {
    Order creat();

    Order pay(int id);

    Order deliver(int id);

    Order receive(int id);

    Map<Integer, Order> getOrders();
}
