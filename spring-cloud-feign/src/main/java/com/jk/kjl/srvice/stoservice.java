package com.jk.kjl.srvice;


import com.jk.kjl.entity.OrderEntity;
import com.jk.kjl.srvice.Hystrix.stoHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@FeignClient(value="provider",fallback = stoHystrix.class)
public interface stoservice {
    @RequestMapping("/reqFeign")
    public String reqFeign();

    /*@RequestMapping("/sto")
    public List<storerank> sto();*/

    @RequestMapping("list")
    public List<OrderEntity> list();

    @RequestMapping("delete")
    public void delete(@RequestParam Integer orderid);

    @RequestMapping("/add")
    public OrderEntity add(@RequestBody OrderEntity order);

    @RequestMapping("/selectOrderById")
    public OrderEntity selectOrderById(@RequestParam Integer orderId);
}
