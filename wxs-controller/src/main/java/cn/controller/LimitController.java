package cn.controller;

import cn.pojo.Coupons;
import cn.pojo.Dishes;
import cn.pojo.Menu;
import cn.pojo.Order;
import cn.wxs.limitService.LimitService;
import com.wordnik.swagger.annotations.ApiImplicitParam;
import com.wordnik.swagger.annotations.ApiImplicitParams;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.annotation.OrderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/fenye")
public class LimitController {
    @Autowired
    private LimitService ls;

    //查菜品
    @ApiOperation(value = "查询菜品", httpMethod = "GET", response = Menu.class, notes = "菜品集合")
    @ResponseBody
    @RequestMapping("/limit")
    @ApiImplicitParams({@ApiImplicitParam(name = "index",value="页码"), @ApiImplicitParam(name = "pagesize",value="每页显示量")})
    public  String dsf(Integer index, Integer pagesize){
        return ls.getPageByIndex(index,pagesize); }

    @ApiOperation(value = "查询菜品根据菜品种类 ", httpMethod = "GET", response = Menu.class, notes = "菜品集合")
    @ResponseBody
    @RequestMapping("/dmenu")
    @ApiImplicitParams({@ApiImplicitParam(name = "mdishes",value="种类"),@ApiImplicitParam(name = "index",value="页码"), @ApiImplicitParam(name = "pagesize",value="每页显示量")})
    public  String dsfd(Integer mdishes,Integer index, Integer pagesize){
        return ls.getmenu(mdishes,index,pagesize); }

    //查菜品种类
    @ApiOperation(value = "菜品种类 ", httpMethod = "GET", response = Dishes.class, notes = "菜品种类集合")
    @ResponseBody
    @RequestMapping("/dshesinfo")
    @ApiImplicitParams({@ApiImplicitParam(name = "index",value="页码"), @ApiImplicitParam(name = "pagesize",value="每页显示量")})

    public String df(Integer index, Integer pagesize){
        return  ls.getDishesIndex(index,pagesize);}

    //查订单
    @ApiOperation(value = "订单查询 ", httpMethod = "GET", response = OrderUtils.class, notes = "订单集合")
    @ResponseBody
    @RequestMapping("/orderinfo")
    @ApiImplicitParams({@ApiImplicitParam(name = "index",value="页码"), @ApiImplicitParam(name = "pagesize",value="每页显示量")})
    public String dssf(Integer index, Integer pagesize){
        return ls.getOrderIndex(index,pagesize);
    }

    @ApiOperation(value = "店铺优惠券 ", httpMethod = "GET", response = Coupons.class, notes = "店铺优惠券集合")
    @ResponseBody
    @RequestMapping("/cou")
    @ApiImplicitParams({@ApiImplicitParam(name = "index",value="页码"), @ApiImplicitParam(name = "pagesize",value="每页显示量")})
    public String f(Integer index, Integer pagesize){
        return ls.getCouponsIndex(index,pagesize);
    }



    @ApiOperation(value = "订单结账 ", httpMethod = "GET", response = String.class, notes = "订单价格")
    @ResponseBody
    @RequestMapping("/redis")
    @ApiImplicitParams({@ApiImplicitParam(name = "id",value = "用户id"),@ApiImplicitParam(name = "num",value = "第几条订单")})
    public String sdfv(Integer id, Integer num){
        return ls.UserOrder(id,num);
    }
    @ApiOperation(value = "用户优惠券", httpMethod = "GET", response = Coupons.class, notes = "用户优惠券集合")
    @ResponseBody
    @RequestMapping("/caufy")
    @ApiImplicitParams({@ApiImplicitParam(name="cauuid",value = "用户id"),@ApiImplicitParam(name = "index",value="页码"), @ApiImplicitParam(name = "pagesize",value="每页显示量")})
    public String  bf(Integer cauuid,Integer index,Integer pagesize){

        return ls.getCaU(cauuid,index,pagesize);
    }

    @ApiOperation(value = "用户订单", httpMethod = "GET", response = Order.class, notes = "用户订单集合")
    @ResponseBody
    @RequestMapping("/userorder")
    @ApiImplicitParams({@ApiImplicitParam(name = "uid",value = "用户ID")})
    public String bbb(Integer uid){

        return ls.getUserOrder(uid);
    }
    @ApiOperation(value = "菜品信息", httpMethod = "GET", response = Menu.class, notes = "菜品信息对象")
    @ResponseBody
    @RequestMapping("/gf")
    @ApiImplicitParams({@ApiImplicitParam(name = "id",value = "菜品ID")})
    public  String gf(Integer id){
        return ls.getMenuInfo(id);
    }
}
