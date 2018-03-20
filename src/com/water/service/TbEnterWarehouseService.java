package com.water.service;

import java.util.List;

import com.water.pojo.TbEnterWarehouse;

public interface TbEnterWarehouseService {

	/**
	 * 得到所有商品
	 * @param enterWarehouse
	 * @return
	 */
	List<TbEnterWarehouse> getAllTbEnterWarehouse(TbEnterWarehouse enterWarehouse);
	/**
	 * 得到单一的商品
	 * @param enterWarehouse
	 * @return
	 */
	TbEnterWarehouse getTbEnterWarehouse(TbEnterWarehouse enterWarehouse);
	/**
	 * 插入或者更新一个入库信息
	 * @param tbEnterWarehouse
	 * @return
	 */
	boolean addOrUpdateEnterWarehouse(TbEnterWarehouse tbEnterWarehouse);

}
