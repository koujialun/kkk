package com.jk.kjl.controller;

import com.jk.kjl.entity.OrderEntity;
import com.jk.kjl.entity.storerank;
import com.jk.kjl.srvice.stoservice;
import com.jk.kjl.utils.RedisUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.annotation.Resource;
import java.util.List;

@Controller
public class stocontroller {

    @Resource
    private stoservice stoservice;

@RequestMapping("/reqFeign")
@ResponseBody
    public String reqFeign(){
    return stoservice.reqFeign();
}

    /*@RequestMapping("/index")
    public String index(){

        return "index";
    }*/
   @RequestMapping("/find")
    public String find(){
    return stoservice.reqFeign();
}
   /* @RequestMapping("/list")
    public List<storerank> sto(){
       return stoservice.sto();
    }*/
   @RequestMapping("toadd")
   public String toadd(Model model){

       model.addAttribute("order",new OrderEntity());
       return "add";
   }
   @RequestMapping("/list")
   public String list(Model model){
       model.addAttribute("orderlist",stoservice.list());
       return  "list";
   }
    @RequestMapping("/deleteOrder")
    public String delete(Integer orderid){
        stoservice.delete(orderid);
        return "redirect:list";
    }
@RequestMapping("/add")
    public String add(OrderEntity order){
    stoservice.add(order);
     return "redirect:list";
}
    @RequestMapping("/selectOrderById")
    public String selectOrderById(Integer orderId, Model model) {
        model.addAttribute("order", stoservice.selectOrderById(orderId));
        return "add";
    }

}
