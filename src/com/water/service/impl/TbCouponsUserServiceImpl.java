package com.water.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.water.mapper.TbCouponsMapper;
import com.water.mapper.TbCouponsUserMapper;
import com.water.pojo.TbCoupons;
import com.water.pojo.TbCouponsUserVO;
import com.water.pojo.TbUser;
import com.water.service.TbCouponsService;
import com.water.service.TbCouponsUserService;
import com.water.util.AddOrUpdateUtils;
import com.water.util.GetUUIDUtils;

@Service
public class TbCouponsUserServiceImpl implements TbCouponsUserService{
	@Autowired
	private TbCouponsUserMapper tbCouponsUserMapper;
	@Autowired
	private TbCouponsMapper tbCouponsMapper;
	
	@Override
	public boolean addTbCouponsUsers(String[] userIds, Integer[] couponsNums, String couponsId) {
		int flag = 0;
		int countCouponsNums = 0;
		TbCoupons tbCoupons = new TbCoupons();
		tbCoupons.setId(couponsId);
		tbCoupons = tbCouponsMapper.getTbCoupons(tbCoupons);
		//防止非法注入，如果不存在此优惠券id，那么直接返回false
		if (null == tbCoupons) {
			return false;
		}
		List<TbCouponsUserVO> vos = new ArrayList<TbCouponsUserVO>();
		
		if (userIds != null && couponsNums != null && couponsId != null) {
			for (int i = 0; i < userIds.length; i++) {
				//防止非法注入，如果小于0，那么跳过此次添加
				if (couponsNums[i] == null || couponsNums[i] < 0) {
					continue;
				}
				//将所有的优惠券加起来
				countCouponsNums+=couponsNums[i];
				
				TbCouponsUserVO voTemp = new TbCouponsUserVO();
				
				TbUser tbUserTemp = new TbUser();
				tbUserTemp.setId(userIds[i]);
				
				voTemp.setId(GetUUIDUtils.getUUID());
				voTemp.setTbUser(tbUserTemp);
				voTemp.setTbCoupons(tbCoupons);
				voTemp.setCouponsNum(couponsNums[i]);
				AddOrUpdateUtils.addOrUpdateUtils(voTemp);
				
				vos.add(voTemp);
			}
			if (tbCoupons.getOverNum() >= countCouponsNums && vos != null && !vos.isEmpty()) {
				//添加到优惠券用户表
				flag = tbCouponsUserMapper.addTbCouponsUsers(vos);
				//得到减少后的优惠券
				tbCoupons.setOverNum(tbCoupons.getOverNum() - countCouponsNums);
				//更新优惠券剩余数量
				tbCouponsMapper.updateTbCoupons(tbCoupons);
			}
		}
		return flag > 0 ? true : false;
	}

	@Override
	public List<TbCouponsUserVO> getAllTbCouponsUsers(TbCouponsUserVO tbCouponsUserVO) {
		return tbCouponsUserMapper.getAllTbCouponsUsers(tbCouponsUserVO);
	}

	@Override
	public boolean addTbCouponsUser(TbCouponsUserVO couponsUserVO) {
		couponsUserVO.setId(GetUUIDUtils.getUUID());
		AddOrUpdateUtils.addOrUpdateUtils(couponsUserVO);
		int flag = tbCouponsUserMapper.addTbCouponsUser(couponsUserVO);
		return flag > 0 ? true :false ;
	}
}
