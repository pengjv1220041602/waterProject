package com.water.mapper;

import java.util.List;

import com.water.pojo.TbCoupons;

public interface TbCouponsMapper {

	/**
	 * 得到所有的优惠券
	 * @param tbCoupon
	 * @return
	 */
	List<TbCoupons> getAllTbCoupons(TbCoupons tbCoupon);

	/**
	 * 得到单一的优惠券
	 * @param tbCoupons
	 * @return
	 */
	TbCoupons getTbCoupons(TbCoupons tbCoupons);

	/**
	 * 更新优惠券
	 * @param tbCoupons
	 * @return
	 */
	int updateTbCoupons(TbCoupons tbCoupons);

	/**
	 * 添加优惠券
	 * @param tbCoupons
	 * @return
	 */
	int insertTbCoupons(TbCoupons tbCoupons);

	/**
	 * 删除一个优惠券
	 * @param tbCoupons
	 * @return
	 */
	int deleteCoupons(TbCoupons tbCoupons);
	
}
