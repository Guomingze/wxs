package cn.order.impl;

import cn.dao.OrderDao;
import cn.order.OrderAndMenuService;
import cn.order.OrderService;
import cn.pojo.Order;
import cn.pojo.User;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private RedisTemplate ops;

    public String selorder(String id) {

        return "dedd" ;
    }

    public String deleorder(String oid, String uid) {

        return "ddd" ;
    }

    public String insertorder(Order order) {

        return "";
    }
}
