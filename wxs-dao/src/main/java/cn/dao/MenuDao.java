package cn.dao;

import cn.pojo.Menu;

import java.util.List;

public interface MenuDao {
    /**
     * 查询全部菜品
     * @param menu
     * @return
     */
    List<Menu> getAllMenu(Menu menu);

    /**
     * 添加一款菜品
     * @param menu 菜品对象
     * @return 受影响行数
     */
    int addMenu(Menu menu);

    /**
     * 修改菜品信息
     * @param menu 菜品对象
     * @return 受影响行数
     */
    int updateMen(Menu menu);

    /**
     * 根据种类查菜品
     * @param menu
     * @return
     */
    List<Menu> getAllMenuByDishes(Menu menu);

    Menu getMenuInfo(int id);
}
