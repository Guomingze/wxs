package cn.wxs.limitServiceImpl;

import cn.dao.DishesDao;
import cn.dao.MenuDao;
import cn.dao.OrderDao;
import cn.pojo.Dishes;
import cn.pojo.Menu;
import cn.pojo.Order;
import cn.wxs.limitService.LimitService;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LimitServiceImpl implements LimitService {
    @Autowired
    private MenuDao md;
    public MenuDao getMd() {
        return md;
    }
    public void setMd(MenuDao md) {
        this.md = md;
    }
    @Autowired
    private DishesDao dd;
    public DishesDao getDd() { return dd; }
    public void setDd(DishesDao dd) { this.dd = dd; }
    @Autowired
    private OrderDao od;
    public OrderDao getOd() { return od; }
    public void setOd(OrderDao od) { this.od = od; }
    /**
     * 插件显示菜品分页
     * @param index 页码
     * @param pagesize 显示条数
     * @return菜品集合的json字符串
     */
    public String getPageByIndex(int index, int pagesize) {
        PageHelper.startPage(index,pagesize);
        List<Menu> allMenu = md.getAllMenu(null);
        PageInfo<Menu> pageInfo = new PageInfo<Menu>(allMenu);
        return  JSON.toJSONString(pageInfo);

    }

    /**
     * 插件显示菜品种类分页
     * @param index 页码
     * @param pagesize 显示条数
     * @return 菜品种类集合的json字符串
     */
    public String getDishesIndex(int index, int pagesize) {
        PageHelper.startPage(index,pagesize);
        List<Dishes> allDishes = dd.getAllDishes(null);
        PageInfo<Dishes> pageInfo = new PageInfo<Dishes>(allDishes);
        return JSON.toJSONString(pageInfo);
    }

    public String getOrderIndex(int index, int pagesize) {
        PageHelper.startPage(index, pagesize);
        List<Order> allOrder = od.getOrdersByOrder(null);
        PageInfo<Order> pageInfo = new PageInfo<Order>(allOrder);
        return JSON.toJSONString(pageInfo);
    }
}
