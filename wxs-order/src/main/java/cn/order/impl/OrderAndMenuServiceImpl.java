package cn.order.impl;

import cn.order.OrderAndMenuService;
import cn.pojo.OrderAndMenu;
import cn.util.OrdeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderAndMenuServiceImpl implements OrderAndMenuService {
    @Autowired
  private   RedisTemplate redisTemplate;
    public OrdeUtil seloam(OrdeUtil ordeUtil) {
        if (ordeUtil != null){

        }

        return 0;
    }

    public int insertoam(OrderAndMenu orderAndMenu) {
        return 0;
    }
}
