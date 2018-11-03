package cn.controller;

import cn.order.OrderAndMenuService;
import cn.util.OrdeUtil;
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
    public String aa(OrdeUtil ordeUtil){
        return orderAndMenuService.insertoam(ordeUtil);
    }
}
