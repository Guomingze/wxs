package cn.controller;

import cn.business.impl.LoginImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(value="登录controller",tags={"用户登录接口"})
@Controller
@RequestMapping("/Entrance")
public class Entrance {

    @Autowired
    private LoginImpl logins;

    @ResponseBody
    @RequestMapping("/login")
    public String login(String code){
        return logins.login(code);
    }
}
