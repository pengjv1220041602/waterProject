package com.water.service;

import java.util.List;

import com.water.pojo.TbCouponsUserVO;

public interface TbCouponsUserService {

	/**
	 * 添加对应的用户和优惠券
	 * @param tbCouponsUserVO
	 * @param userIds
	 * @return
	 */
	boolean addTbCouponsUsers(String[] userIds, Integer[] couponsNums, String couponsId);

	/**
	 * 获取对应的优惠券集合
	 * @param tbCouponsUserVO
	 * @return
	 */
	List<TbCouponsUserVO> getAllTbCouponsUsers(TbCouponsUserVO tbCouponsUserVO);
	
	/**
	 * 添加一个用户和优惠券关系
	 * @param couponsUserVO
	 * @return
	 */
	boolean addTbCouponsUser(TbCouponsUserVO couponsUserVO) ;
}
