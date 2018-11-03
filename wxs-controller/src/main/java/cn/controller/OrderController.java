package cn.controller;

import cn.order.OrderAndMenuService;
import cn.pojo.OrderAndMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OrderController {
    @Autowired
    private OrderAndMenuService orderAndMenuService;
    @ResponseBody
    @RequestMapping("/test")
    public String aa(OrderAndMenu orderAndMenu){
        String a = "失败";
        if(orderAndMenuService.insertoam(orderAndMenu) > 0 ){
            a = "成功";
        }
        return a;
    }
}
