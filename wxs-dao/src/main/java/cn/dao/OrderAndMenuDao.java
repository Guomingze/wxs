package cn.dao;

import cn.pojo.Menu;
import cn.pojo.Order;

import java.util.List;

public interface OrderAndMenuDao {
    /**
     * 根据订单id查询x用户的订单中的菜品信息
     * @param order 订单中的订单id
     * @return
     */
    List<Menu> selectUserMenu(Order order);
}
