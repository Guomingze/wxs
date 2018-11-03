package cn.order.impl;

import cn.dao.UserDao;
import cn.order.OrderAndMenuService;
import cn.pojo.User;
import cn.util.OpenIdBycode;
import cn.util.OrdeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.TimeUnit;

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
        System.out.println(ordeUtil.getUid());
        return ordeUtil;
    }

    public String insertoam(OrdeUtil ordeUtil) {
        String aa = "点餐失败";
        Integer ii = 1;
        ValueOperations<String, Map<Integer,OrdeUtil>> operations = redisTemplate.opsForValue();
        OrdeUtil seloam = seloam(ordeUtil);
        String a = "用户id" + ordeUtil.getUid();
        System.out.println(operations.get(a));
        if (operations.get(a) == null){
            Map<Integer,OrdeUtil> map = new HashMap<Integer, OrdeUtil>();
            map.put(ii,seloam);
            operations.set(a,map);
            redisTemplate.expire("a", 1, TimeUnit.DAYS);
            System.out.println(1);
            aa ="点餐成功";
        }else {
            Map<Integer, OrdeUtil> map = operations.get(a);
            Set<Integer> keys = map.keySet();
            Object[] objs = keys.toArray();
            int[] ints = new int[objs.length];
            for (int x = 0; x < objs.length; x++) {
                ints[x] = Integer.parseInt(objs[x].toString());
            }
            System.out.println(2);
            Arrays.sort(ints);
            int bigInt = ints[ints.length - 1];
            map.put(bigInt + 1, ordeUtil);
            operations.set(a,map);
            aa = "继续点餐成功";
            redisTemplate.expire("a", 1, TimeUnit.DAYS);
        }
        return aa;
    }
}
