package cn.order.impl;

import cn.dao.OrderDao;
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
        String list = null;
        if (id != null) {
            int uid = Integer.parseInt(id);
            Order order = new Order();
            User user = new User();
            user.setUid(uid);
            order.setOuser(user);
            List<Order> ordersByOrder = orderDao.getOrdersByOrder(order);
            if (ordersByOrder != null) {
                list = JSON.toJSONString(ordersByOrder);
            }
        }
        return list;
    }

    public String deleorder(String oid, String uid) {
        String aa = "删除失败";
        if (oid != null && uid != null) {
            int id = Integer.parseInt(uid);
            int d = Integer.parseInt(oid);
            String a = "用户id" + id;
            System.out.println(ops.opsForValue().get(a));
            Map<Integer, Order> map = (Map<Integer, Order>) ops.opsForValue().get(a);
            map.remove(d);
            ops.opsForValue().set(a, map);
            aa = "删除成功";
        }
        return aa;
    }

    public String insertorder(Order order) {
        String aa = "添加失败";
        if (order != null) {
            String a = "用户id" + order.getOuser().getUid();
            Map<Integer, Order> map = new HashMap<Integer, Order>();
            ValueOperations<String, Map<Integer, Order>> valueOper = ops.opsForValue();
            if (order.getOtype() > 0) {
                map.put(order.getOid(), order);
                valueOper.set(a, map);
                ops.expire(order.getOuser().getUid(),20, TimeUnit.SECONDS);
            } else if (order.getOtype() == 0) {
                orderDao.addOrder(order);
            }
            aa = "添加成功";
        }
        return aa;
    }
}
