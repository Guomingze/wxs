package cn.controller;

import cn.wxs.limitService.LimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/test")
public class LimitController {
    @Autowired
    private LimitService ls;
    @ResponseBody
    @RequestMapping("/menuinfo")
    //查菜品
    public  String dsf(){ return ls.getPageByIndex(2,5); }
    //查菜品种类
    @ResponseBody
    @RequestMapping("/deshesinfo")
    public String df(){ return  ls.getDishesIndex(1,5);}

    //查订单
    @ResponseBody
    @RequestMapping("/orderinfo")
    public String dssf(){
        return ls.getOrderIndex(1,2);
    }
}
