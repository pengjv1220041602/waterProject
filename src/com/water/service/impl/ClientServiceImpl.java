package com.water.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.water.pojo.TbCoupons;
import com.water.pojo.TbCouponsUserVO;
import com.water.service.ClientService;
import com.water.service.TbCouponsService;
import com.water.service.TbCouponsUserService;

@Service
public class ClientServiceImpl implements ClientService{

	@Autowired
	private TbCouponsUserService tbCouponsUserService;
	@Autowired
	private TbCouponsService tbCouponsService;
	
	@Override
	public Map<String, String> getCoupons(TbCouponsUserVO tbCouponsUserVO) {
		Map<String, String> mapResult = new HashMap<String,String>();
		List<TbCouponsUserVO> couponsUsers = tbCouponsUserService.getAllTbCouponsUsers(tbCouponsUserVO);
		if (couponsUsers != null && couponsUsers.size() > 0) {
			mapResult.put("result", "已经有此优惠券"+couponsUsers.get(0).getCouponsNum()+"张");
			return mapResult;
		}
		TbCoupons couponsTemp = tbCouponsUserVO.getTbCoupons();
		couponsTemp.setCouponsBeginTime(new Date());
		couponsTemp.setCouponsEndTime(new Date());
		TbCoupons tbCoupons = tbCouponsService.getTbCoupons(couponsTemp);
		if (tbCoupons == null) {
			mapResult.put("result", "不在抢购时间范围内");
			return mapResult;
		}
		Random rand = new Random();
		int num = rand.nextInt(tbCoupons.getCouponsNum()+1);
		tbCouponsUserVO.setCouponsNum(num);
		tbCoupons.setCouponsNum(tbCoupons.getCouponsNum() - num );
		tbCouponsService.addOrUpdateTbCoupons(tbCoupons);
		tbCouponsUserService.addTbCouponsUser(tbCouponsUserVO);
		mapResult.put("result", "您抽到优惠券"+num+"张");
		return mapResult;
	}

}
