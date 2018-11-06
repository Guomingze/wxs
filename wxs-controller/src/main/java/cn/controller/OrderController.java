package cn.controller;

import cn.order.OrderAndMenuService;
import cn.util.OrdeUtil;
import com.wordnik.swagger.annotations.ApiImplicitParam;
import com.wordnik.swagger.annotations.ApiImplicitParams;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderAndMenuService orderAndMenuService;
    @ResponseBody
    @RequestMapping("/addorder")
    @ApiOperation(value = "增加订单 ", httpMethod = "POST", response = String.class, notes = "点餐成功或失败")
    @ApiImplicitParams({@ApiImplicitParam(name = "ordeUtils",value="订单集合")})
    public String aa(@RequestBody List<OrdeUtil> ordeUtils){
        return orderAndMenuService.insertoam(ordeUtils);
    }
}
