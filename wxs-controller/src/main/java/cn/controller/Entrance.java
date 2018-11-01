package cn.controller;

import cn.business.impl.LoginImpl;
import cn.pojo.User;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/Entrance")
@Api(value="登录controller",tags={"用户登录接口"})
public class Entrance {
    @Autowired
    private LoginImpl logins;

    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "登录", httpMethod = "POST", response = User.class, notes = "登录后获取用户ID和username")
    public String login(@ApiParam(name = "code",value = "登录凭证code") String code){
        return logins.login(code);
    }
}

