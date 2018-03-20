package com.water.service;

import java.util.List;

import com.water.pojo.TbProduct;

public interface TbProductService {
	/**
	 * 得到所有的商品
	 * @param tbProduct
	 * @return
	 */
	List<TbProduct> getAllTbProducts(TbProduct tbProduct);

	/**
	 * 得到单个商品
	 * @param tbProduct
	 * @return
	 */
	TbProduct getTbProduct(TbProduct tbProduct);
	
	/**
	 * 添加商品
	 * @param tbProduct
	 * @return
	 */
	boolean addOrUpdateTbProduct(TbProduct tbProduct);
	
}
