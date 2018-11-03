package cn.order;

import cn.pojo.OrderAndMenu;
import cn.util.OrdeUtil;


public interface OrderAndMenuService {
    /**
     * 根据订单id查找订单信息详情
     * @param oid 订单id
     * @return  订单信息详情集合
     */
    OrdeUtil seloam(OrdeUtil ordeUtil);

    /**
     * 增加一条订单详情信息
     * @param orderAndMenu 订单详情信息对象
     * @return 受影响行数
     */
    int insertoam(OrderAndMenu orderAndMenu);
}
