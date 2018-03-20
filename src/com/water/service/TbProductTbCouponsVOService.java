package com.water.service;

import java.util.List;

import com.water.pojo.TbProductTbCouponsVO;

public interface TbProductTbCouponsVOService {

	/**
	 * 得到所有的商品
	 * @param tbProductTbCouponsVO
	 * @return
	 */
	List<TbProductTbCouponsVO> getProductAndCoupons(TbProductTbCouponsVO tbProductTbCouponsVO);

	/**
	 * 添加或更新商品优惠券关系
	 * @param tbProductTbCouponsVO
	 * @param proIds
	 * @return
	 */
	boolean addOrUpdateProductAndCoupons(TbProductTbCouponsVO tbProductTbCouponsVO, String[] proIds);

	/**
	 * 优惠券及商品
	 * @param tbProductTbCouponsVO
	 * @return
	 */
	List<TbProductTbCouponsVO> getAllProductAndCoupons(TbProductTbCouponsVO tbProductTbCouponsVO);
}
