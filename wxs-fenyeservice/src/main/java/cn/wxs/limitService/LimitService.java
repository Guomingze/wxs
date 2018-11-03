package cn.wxs.limitService;

public interface LimitService {
    /**
     * 菜品信息分页展示
     * @param index 页码
     * @param pagesize 每页显示量
     * @return 菜品信息集合的json字符串
     */
    String getPageByIndex(int index, int pagesize);

    /**
     * 菜品种类分页显示
     * @param index 页码
     * @param pagesize 每页显示量
     * @return 菜品种类集合的json字符串
     */
    String getDishesIndex(int index,int pagesize);

    /**
     * 分页展示订单
     * @param index
     * @param pagesize
     * @return
     */
    String getOrderIndex(int index, int pagesize);


}
