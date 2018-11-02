package cn.controller;

import cn.wxs.recommendDishesService.RecommendDishesService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test")
@Api(value = "/src",description ="Show the hot push merchandise" )
public class RecommenDishesController {
    @Autowired
    private RecommendDishesService re;
    @ResponseBody
    @RequestMapping("/test")
    public String aa(){
        return re.addRedis();
    }
}
