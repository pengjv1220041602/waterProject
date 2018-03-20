package com.water.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.water.mapper.TbProductTbCouponsVOMapper;
import com.water.pojo.TbCoupons;
import com.water.pojo.TbProduct;
import com.water.pojo.TbProductTbCouponsVO;
import com.water.service.TbProductTbCouponsVOService;
import com.water.util.AddOrUpdateUtils;
import com.water.util.GetUUIDUtils;

@Service
public class TbProductTbCouponsVOServiceImpl implements TbProductTbCouponsVOService{

	@Autowired
	private TbProductTbCouponsVOMapper tbProductTbCouponsVOMapper;
	@Override
	public List<TbProductTbCouponsVO> getProductAndCoupons(TbProductTbCouponsVO tbProductTbCouponsVO) {
		List<TbProductTbCouponsVO> VOs = tbProductTbCouponsVOMapper.getProductAndCoupons(tbProductTbCouponsVO);
		return VOs;
	}
	@Override
	public boolean addOrUpdateProductAndCoupons(TbProductTbCouponsVO tbProductTbCouponsVO, String[] proIds) {
		
	/*	TbProductTbCouponsVO tbProductTbCouponsVO = new TbProductTbCouponsVO();
		TbCoupons tbCoupons = new TbCoupons();
		tbCoupons.setId(couId);
		tbProductTbCouponsVO.setTbCoupons(tbCoupons);*/
		
		List<TbProductTbCouponsVO> listPCVOs = new ArrayList<TbProductTbCouponsVO>();
		int resultNum = 0;		
		resultNum = tbProductTbCouponsVOMapper.deleteProductAndCoupons(tbProductTbCouponsVO);
		if (proIds != null) {
			for (String proId : proIds) {
				TbProductTbCouponsVO vo = new TbProductTbCouponsVO();
				
				TbProduct p = new TbProduct();
				p.setId(proId);
				
				TbCoupons c = new TbCoupons();
				c.setId(tbProductTbCouponsVO.getTbCoupons().getId());
				
				vo.setTbProduct(p);
				vo.setTbCoupons(c);
				AddOrUpdateUtils.addOrUpdateUtils(vo);
				vo.setId(GetUUIDUtils.getUUID());
				listPCVOs.add(vo);
			}
			if (!listPCVOs.isEmpty()) {
				resultNum = tbProductTbCouponsVOMapper.addProductAndCoupons(listPCVOs);
			}
		} //if (proIds != null)
		return resultNum > 0 ? true : false;
	}
	
	@Override
	public List<TbProductTbCouponsVO> getAllProductAndCoupons(TbProductTbCouponsVO tbProductTbCouponsVO) {
		List<TbProductTbCouponsVO> allProductAndCoupons = tbProductTbCouponsVOMapper.getAllProductAndCoupons(tbProductTbCouponsVO);
		return allProductAndCoupons;
	}
}
