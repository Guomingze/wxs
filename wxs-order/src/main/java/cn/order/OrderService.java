package cn.order;

import cn.pojo.Order;

public interface OrderService {
    /**
     * 根据用户id查找用户订单
     *
     * @param id 用户id
     * @return json对象
     */
    String selorder(String id);

    /**
     * 根据订单id删除订单信息
     * @param oid  订单id
     * @return 受影响行数
     */
    String deleorder(String oid,String uid);

    /**
     * 新增一条订单信息
     * @param order 订单对象
     * @return 受影响行数
     */
    String insertorder(Order order);
}
