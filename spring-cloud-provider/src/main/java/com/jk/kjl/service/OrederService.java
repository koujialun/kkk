package com.jk.kjl.service;

import com.jk.kjl.entity.OrderEntity;

import java.util.List;

public interface OrederService {

    List<OrderEntity> list();

    void delete(Integer orderid);

    OrderEntity add(OrderEntity order);

    OrderEntity selectOrderById(Integer orderId);
}
