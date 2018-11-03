package cn.wxs.recommendDishesServiceImpl;

import cn.dao.MenuDao;
import cn.pojo.Menu;
import cn.wxs.recommendDishesService.RecommendDishesService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecommendDishesServiceImpl implements RecommendDishesService {
    @Autowired
    private MenuDao menuDao;
    @Autowired
    private RedisTemplate redisTemplate;

    public RedisTemplate getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public MenuDao getMenuDao() {
        return this.menuDao;
    }

    public void setMenuDao(MenuDao menuDao) {
        this.menuDao = menuDao;
    }

    private String selectCoupons() {
        Menu menu;
        List<Menu> allMenu = menuDao.getAllMenu(null);
        if (allMenu.size() > 0) {
            for (int i = 0; i < allMenu.size(); i++) {
                for (int j = 0; j < allMenu.size() - 1; j++) {
                    if (allMenu.get(i).getFrequency() > allMenu.get(j).getFrequency()) {
                        menu = allMenu.get(i);
                        allMenu.set(i, allMenu.get(j));
                        allMenu.set(j, menu);
                    }
                }
            }
            List<Menu> recommendDishes = new ArrayList<Menu>();
            for (int i = 0; i < 5; i++) {
                recommendDishes.add(allMenu.get(i));
            }
            return JSON.toJSONString(recommendDishes);
        }
        return null;
    }

    public String addRedis() {
        String selectCoupon;
        try {
            selectCoupon=(String) redisTemplate.opsForValue().get("recommendDishes");
            if(selectCoupon.equals(null)){}
        }catch (Exception e){
            redisTemplate.opsForValue().set("recommendDishes", selectCoupons());
            selectCoupon = (String) redisTemplate.opsForValue().get("recommendDishes");
        }
            return selectCoupon;
    }


    @Scheduled(cron="0 15 5 ? * *")  //每天上午5：15触发
    private void deleRedis(){
        redisTemplate.delete("recommendDishes");
    }
}
