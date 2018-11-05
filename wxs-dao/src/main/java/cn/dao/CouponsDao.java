package cn.dao;

import cn.pojo.Coupons;

import java.util.List;

public interface CouponsDao {
    /**
     * 查询优惠券信息
     * @param coupons
     * @return
     */
    List<Coupons> getAllCoupons (Coupons coupons);
    /**
     * 修改用户优惠券状态
     *
     * @param cou 优惠券对象
     * @return 受影响心数
     */
    int updatacoupons(Coupons cou);

    /**
     * 新增一个优惠券
     *
     * @param cou 优惠券对象
     * @return 受影响心数
     */
    int insertcoupons(Coupons cou);


}
