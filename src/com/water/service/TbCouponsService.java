package com.water.service;

import java.util.List;

import com.water.pojo.TbCoupons;

public interface TbCouponsService {

	/**
	 * 得到所有对应的优惠券
	 * @param tbCoupon
	 * @return
	 */
	List<TbCoupons> getAllTbCoupons(TbCoupons tbCoupon);
	/**
	 * 得到所有对应的优惠券通过当前时间
	 * @param tbCoupon
	 * @return
	 */
	List<TbCoupons> getAllTbCouponsByTime(TbCoupons tbCoupon);

	/**
	 * 得到单一的优惠券
	 * @param tbCoupons
	 * @return
	 */
	TbCoupons getTbCoupons(TbCoupons tbCoupons);

	/**
	 * 添加或更新优惠券
	 * @param tbCoupons
	 * @return
	 */
	boolean addOrUpdateTbCoupons(TbCoupons tbCoupons);

	/**
	 * 删除一个优惠券
	 * @param tbCoupons
	 * @return
	 */
	boolean deleteCoupons(TbCoupons tbCoupons);

}
