package cn.controller;

import cn.wxs.recommendDishesService.RecommendDishesService;
import com.wordnik.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCommand;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/RecommenDishes")
@Api(value = "/src",description ="Show the hot push merchandise" )
public class RecommenDishesController {
    @Autowired
    private RecommendDishesService re;
    @ResponseBody
    @RequestMapping("/RecommenDishes")
    @ApiOperation(value = "推荐热卖 ", httpMethod = "GET", response = RedisCommand.class, notes = "热卖的集合")
    public String aa(){
        return re.addRedis();
    }
}
