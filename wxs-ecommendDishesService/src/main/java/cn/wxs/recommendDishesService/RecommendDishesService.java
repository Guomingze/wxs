package cn.wxs.recommendDishesService;

public interface RecommendDishesService {
     /**
      * redis中保存五条昨天销售最多的菜品保存24小时
      * @return 五条菜品信息
      */
     String addRedis();
}
