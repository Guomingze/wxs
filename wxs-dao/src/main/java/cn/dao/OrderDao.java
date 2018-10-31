package cn.dao;

import cn.pojo.Order;

import java.util.List;

public interface OrderDao {
    /**
     * 根据Order的属性,查询符合条件的Order对象集合
     * @param order Order对象
     * @return Order对象集合
     */
    List<Order> getOrdersByOrder(Order order);

    /**
     * 添加Order
     * @param order
     * @return 影响行数
     */
    int addOrder(Order order);

    /**
     * 修改Order信息
     * @param order
     * @return 影响行数
     */
    int updataOrder(Order order);
}
