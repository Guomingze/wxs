package cn.wxs.limitService;

import cn.util.OrdeUtil;
import org.springframework.data.redis.core.ValueOperations;

import java.util.List;
import java.util.Map;

public interface LimitService {
    /**
     * 菜品信息分页展示
     *
     * @param index    页码
     * @param pagesize 每页显示量
     * @return 菜品信息集合的json字符串
     */
    String getPageByIndex(int index, int pagesize);

    /**
     * 菜品种类分页显示
     *
     * @param index    页码
     * @param pagesize 每页显示量
     * @return 菜品种类集合的json字符串
     */
    String getDishesIndex(int index, int pagesize);

    /**
     * 分页展示订单
     *
     * @param index
     * @param pagesize
     * @return
     */
    String getOrderIndex(int index, int pagesize);

    /**
     * 分页展示优惠券
     *
     * @param index
     * @param pagesize
     * @return
     */
    String getCouponsIndex(int index, int pagesize);

    /**
     * redis中读取订单信息
     *
     * @param id
     */
    ValueOperations<String, Map<Integer, List<OrdeUtil>>> testRedis(int id);


    /**
     * 算钱
     * @param id
     * @param num
     * @return
     */
    String UserOrder(int id,int num);

    /**
     * 显示用户的订单
     * @param uid
     * @return
     */
    String getUserOrder(int uid);

    /**
     * 根据菜品种类查菜单
     * @param mdishes
     * @param index
     * @param pagesize
     * @return
     */
    String getmenu(int mdishes,int index,int pagesize);

    /**
     * 该用户的优惠券
     * @param cauuid
     * @param index
     * @param pagesize
     * @return
     */
    String getCaU(int cauuid,int index,int pagesize);


}
