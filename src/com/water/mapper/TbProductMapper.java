package com.water.mapper;

import java.util.List;

import com.water.pojo.TbProduct;

public interface TbProductMapper {

	/**
	 * 得到对应的所有商品
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
	 * 更新商品
	 * @param tbProduct
	 * @return
	 */
	int updateTbProduct(TbProduct tbProduct);

	/**
	 * 添加商品
	 * @param tbProduct
	 * @return
	 */
	int addTbProduct(TbProduct tbProduct);
	
}
