package com.jk.kjl.service.Impl;

import com.jk.kjl.entity.OrderEntity;
import com.jk.kjl.repository.OrderRepository;
import com.jk.kjl.service.OrederService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrederServiceImpl implements OrederService {

     @Resource
     private OrderRepository OrderRepository;

    @Override
    public List<OrderEntity> list() {

        return OrderRepository.findAll();
    }

    @Override
    public void delete(Integer orderid) {

        OrderRepository.deleteById(orderid);
    }

    @Override
    public OrderEntity add(OrderEntity order) {
        OrderRepository.save(order);
        return order;
    }

    @Override
    public OrderEntity selectOrderById(Integer orderId) {
        return OrderRepository.findById(orderId).get();
    }
}
