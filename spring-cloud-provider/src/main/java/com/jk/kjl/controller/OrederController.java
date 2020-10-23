package com.jk.kjl.controller;

import com.jk.kjl.config.RedisConstant;
import com.jk.kjl.entity.OrderEntity;
import com.jk.kjl.service.OrederService;
import com.jk.kjl.utils.RedisUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;
import java.util.List;

@RestController
public class OrederController {

    @Resource
    private OrederService OrederService;
     @Resource
     private RedisTemplate redisTemplate;

    @Resource
    private RedisUtil redisUtil;

@RequestMapping("list")
public List<OrderEntity> list(){
    List<OrderEntity> userlist= (List) redisUtil.get(RedisConstant.USER_LIST_KEY);
    if(userlist==null || userlist.isEmpty()){
        userlist=OrederService.list();
        redisUtil.set(RedisConstant.USER_LIST_KEY,userlist);
        redisUtil.expire(RedisConstant.USER_LIST_KEY,60);
    }
    return userlist;
}
/*@RequestMapping("/deleteOrder")
  public String delete(Integer orderid){
    OrederService.delete(orderid);
    return "redirect:list";
}*/

@RequestMapping("delete")
public void delete(@RequestParam Integer orderid){

    redisUtil.del(RedisConstant.USER_LIST_KEY);
    OrederService.delete(orderid);
}
/*@RequestMapping("/add")
    public String add(OrderEntity order){
    OrederService.add(order);
     return "redirect:list";
}*/
@RequestMapping("/add")
public OrderEntity add(@RequestBody OrderEntity order){

    redisUtil.delAllKeys(RedisConstant.USER_LIST_KEY);
    return OrederService.add(order);
}
   /* @RequestMapping("/selectOrderById")
    public String selectOrderById(@RequestParam Integer orderId, Model model) {
        model.addAttribute("order", OrederService.selectOrderById(orderId));
        return "add";
    }*/
   @RequestMapping("selectOrderById")
    public OrderEntity selectOrderById(@RequestParam Integer orderId){
       redisUtil.del(RedisConstant.USER_LIST_KEY);
       return OrederService.selectOrderById(orderId);
   }


}
