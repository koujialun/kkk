package com.jk.kjl.srvice.Hystrix;

import com.jk.kjl.entity.OrderEntity;
import com.jk.kjl.srvice.stoservice;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component //将熔断器注入到spring容器中
public class stoHystrix implements stoservice{
    @Override
    public String reqFeign() {
        return "系统错误";
    }

    @Override
    public List<OrderEntity> list() {
        return null;
    }

    @Override
    public void delete(Integer orderid) {

    }

    @Override
    public OrderEntity add(OrderEntity order) {
        return null;
    }

    @Override
    public OrderEntity selectOrderById(Integer orderId) {
        return null;
    }
}
