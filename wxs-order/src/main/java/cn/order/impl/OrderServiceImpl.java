package cn.order.impl;

import cn.dao.OrderDao;
import cn.order.OrderService;
import cn.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;


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
