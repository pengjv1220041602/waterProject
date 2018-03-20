package com.water.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.water.mapper.TbProductMapper;
import com.water.pojo.TbProduct;
import com.water.service.TbProductService;
import com.water.util.AddOrUpdateUtils;
import com.water.util.GetUUIDUtils;
import com.water.util.StringUtils;

@Service
public class TbProductServiceImpl implements TbProductService{

	@Autowired
	private TbProductMapper tbProductMapper;
	
	@Override
	public List<TbProduct> getAllTbProducts(TbProduct tbProduct) {
		List<TbProduct> tbProducts = tbProductMapper.getAllTbProducts(tbProduct);
		return tbProducts;
	}
	
	@Override
	public TbProduct getTbProduct(TbProduct tbProduct) {
		return tbProductMapper.getTbProduct(tbProduct);
	}

	@Override
	public boolean addOrUpdateTbProduct(TbProduct tbProduct) {
		int flag = 0;
		AddOrUpdateUtils.addOrUpdateUtils(tbProduct);
		if (null != tbProduct && !StringUtils.isBlank(tbProduct.getId())) {
			flag = tbProductMapper.updateTbProduct(tbProduct);
		} else {
			tbProduct.setId(GetUUIDUtils.getUUID());
			flag = tbProductMapper.addTbProduct(tbProduct);
		}
		return flag > 0 ? true : false;
	}

}
