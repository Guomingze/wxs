package cn.dao;

import cn.pojo.Dishes;

import java.util.List;

public interface DishesDao {
    /**
     * 查找所有菜品种类
     * @param dishes 菜品种类对象
     * @return  菜品种类集合
     */
    List<Dishes> getAllDishes(Dishes dishes);

    /**
     *  添加一个菜品种类
     * @param dishes  菜品种类对象
     * @return  受影响行数
     */
    int addDishes(Dishes dishes);

    /**
     * 修改菜品种类
     * @param dishes 菜品种类对象
     * @return  受影响行数
     */
    int updateDishes(Dishes dishes);
}
