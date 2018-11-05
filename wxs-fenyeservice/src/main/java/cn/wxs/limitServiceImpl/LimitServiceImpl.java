package cn.wxs.limitServiceImpl;

import cn.dao.CouponsDao;
import cn.dao.DishesDao;
import cn.dao.MenuDao;
import cn.dao.OrderDao;
import cn.pojo.Coupons;
import cn.pojo.Dishes;
import cn.pojo.Menu;
import cn.pojo.Order;
import cn.util.OrdeUtil;
import cn.wxs.limitService.LimitService;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.omg.DynamicAny.DynValueOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LimitServiceImpl implements LimitService {
    @Autowired
    private RedisTemplate redisTemplate;

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
    @Autowired
    private CouponsDao cd;
    public CouponsDao getCd() { return cd; }
    public void setCd(CouponsDao cd) { this.cd = cd; }



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
     * 插件显示菜品分页
     *   * @param mdishes 种类
     * @param index 页码
     * @param pagesize 显示条数
     * @return菜品集合的json字符串
     */
    @Override
    public String getmenu( int mdishes,int index, int pagesize) {
        PageHelper.startPage(index,pagesize);
        Menu menu = new Menu();
        menu.setMdishes(mdishes);
        List<Menu> all = md.getAllMenuByDishes(menu);
        PageInfo<Menu> pageInfo = new PageInfo<Menu>(all);
        return JSON.toJSONString(pageInfo);
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

    /**
     * 插件显示订单分页
     * @param index 页码
     * @param pagesize 显示条数
     * @return 菜品种类集合的json字符串
     */
    public String getOrderIndex(int index, int pagesize) {
        PageHelper.startPage(index, pagesize);
        List<Order> allOrder = od.getOrdersByOrder(null);
        PageInfo<Order> pageInfo = new PageInfo<Order>(allOrder);
        return JSON.toJSONString(pageInfo);
    }

    @Override
    public String getCouponsIndex(int index, int pagesize) {
        PageHelper.startPage(index, pagesize);
        List<Coupons> couponsList = cd.getAllCoupons(null);
        PageInfo<Coupons> pageInfo = new PageInfo<Coupons>(couponsList);
        return JSON.toJSONString(pageInfo);
    }

    public ValueOperations<String, Map<Integer,List<OrdeUtil>>> testRedis(int id) {
        ValueOperations<String, Map<Integer,List<OrdeUtil>>> operations = redisTemplate.opsForValue();
        return operations;
    }



    public String UserOrder(int id,int num){
        Menu menu=new Menu();
        Double money=0.0;
        ValueOperations<String, Map<Integer, List<OrdeUtil>>> MVO = testRedis(id);
        for(int i=0; i<MVO.get("用户id" + id).get(num).size();i++){
            menu.setMid(MVO.get("用户id" + id).get(num).get(i).getMid());
            money+=MVO.get("用户id" + id).get(num).get(i).getNumber()*md.getAllMenu(menu).get(0).getMprice();
        }
        return ""+money+"";
    }


}
