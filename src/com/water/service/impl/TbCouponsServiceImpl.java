package com.water.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.water.mapper.TbCouponsMapper;
import com.water.pojo.TbCoupons;
import com.water.service.TbCouponsService;
import com.water.util.AddOrUpdateUtils;
import com.water.util.GetUUIDUtils;
import com.water.util.StringUtils;

@Service
public class TbCouponsServiceImpl implements TbCouponsService{

	@Autowired
	private TbCouponsMapper tbCouponsMapper;
	@Override
	public List<TbCoupons> getAllTbCoupons(TbCoupons tbCoupon) {
		List<TbCoupons> tbCoupons = tbCouponsMapper.getAllTbCoupons(tbCoupon);
		return tbCoupons;
	}
	@Override
	public List<TbCoupons> getAllTbCouponsByTime(TbCoupons tbCoupon) {
		tbCoupon.setCouponsBeginTime(new Date());
		tbCoupon.setCouponsEndTime(new Date());
		List<TbCoupons> tbCoupons = tbCouponsMapper.getAllTbCoupons(tbCoupon);
		return tbCoupons;
	}
	@Override
	public TbCoupons getTbCoupons(TbCoupons tbCoupons) {
		return tbCouponsMapper.getTbCoupons(tbCoupons);
	}
	@Override
	public boolean addOrUpdateTbCoupons(TbCoupons tbCoupons) {
		int flag = 0;
		AddOrUpdateUtils.addOrUpdateUtils(tbCoupons);
		if(!StringUtils.isBlank(tbCoupons.getId())){
			//查询操作是为了防止剩余数量超过添加数量
			TbCoupons  tbCouponsTemp = new TbCoupons();
			tbCouponsTemp.setId(tbCoupons.getId());
			tbCouponsTemp = tbCouponsMapper.getTbCoupons(tbCouponsTemp);
			//发行的数量  肯定是大于0的  如果等于0那么还没有发行优惠券
			int issue = tbCouponsTemp.getCouponsNum() - tbCouponsTemp.getOverNum();
			//发行数量一定要大于0，说明这个是足够的，小于0是不可以的
			int tempNum = tbCoupons.getCouponsNum() - issue;
			if (tempNum > 0) {
				tbCoupons.setOverNum(tempNum);
				flag = tbCouponsMapper.updateTbCoupons(tbCoupons);
			}
			
		}else{
			tbCoupons.setId(GetUUIDUtils.getUUID());
			tbCoupons.setOverNum(tbCoupons.getCouponsNum());
			flag = tbCouponsMapper.insertTbCoupons(tbCoupons);
		}
		return flag > 0 ? true : false;
	}
	@Override
	public boolean deleteCoupons(TbCoupons tbCoupons) {
		int flag = tbCouponsMapper.deleteCoupons(tbCoupons);
		return flag > 0 ? true : false;
	}

}
