package com.water.mapper;

import java.util.List;

import com.water.pojo.TbCouponsUserVO;

public interface TbCouponsUserMapper {

	/**
	 * 添加用户对应的优惠券
	 * @param a
	 * @return
	 */
	int addTbCouponsUsers(List<TbCouponsUserVO> list);

	/**
	 * 获取对应的优惠券集合
	 * @param tbCouponsUserVO
	 * @return
	 */
	List<TbCouponsUserVO> getAllTbCouponsUsers(TbCouponsUserVO tbCouponsUserVO);

	/**
	 * 添加一个优惠券和用户的对应关系
	 * @param couponsUserVO
	 * @return
	 */
	int addTbCouponsUser(TbCouponsUserVO couponsUserVO);

}
