package com.water.service;

import java.util.Map;

import com.water.pojo.TbCouponsUserVO;

public interface ClientService {
	
	/**
	 * 用于处理获取优惠券的业务逻辑
	 * @param tbCouponsUserVO
	 * @return
	 */
	public Map<String, String> getCoupons(TbCouponsUserVO tbCouponsUserVO);
	
}
