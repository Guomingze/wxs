package cn.order.impl;

import cn.dao.UserDao;
import cn.order.OrderAndMenuService;
import cn.pojo.OrderAndMenu;
import cn.pojo.User;
import cn.util.OpenIdBycode;
import cn.util.OrdeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderAndMenuServiceImpl implements OrderAndMenuService {
    @Autowired
  private   RedisTemplate redisTemplate;
    @Autowired
    private OpenIdBycode openIdBycode;
    @Autowired
    private UserDao userDao;
    @Autowired
    public OrdeUtil seloam(OrdeUtil ordeUtil) {
        if (ordeUtil != null){
            User user = new User();
            String openid = openIdBycode.getOpenid(ordeUtil.getCode());
            user.setUpwd(openid);
            List<User> users = userDao.allUser(user);
            Integer uid = users.get(0).getUid();
            ordeUtil.setUid(uid);
        }
        return ordeUtil;
    }

    public int insertoam(OrderAndMenu orderAndMenu) {
        return 0;
    }
}
