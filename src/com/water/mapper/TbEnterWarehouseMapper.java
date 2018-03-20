package com.water.mapper;

import java.util.List;

import com.water.pojo.TbEnterWarehouse;

public interface TbEnterWarehouseMapper {

	/**
	 * 得到所有的入库信息
	 * @param enterWarehouse
	 * @return
	 */
	List<TbEnterWarehouse> getAllTbEnterWarehouse(TbEnterWarehouse enterWarehouse);

	/**
	 * 得到一个入库信息
	 * @param enterWarehouse
	 * @return
	 */
	TbEnterWarehouse getTbEnterWarehouse(TbEnterWarehouse enterWarehouse);

	/**
	 * 插入一条数据
	 * @param tbEnterWarehouse
	 * @return
	 */
	int insertEnterWarehouse(TbEnterWarehouse tbEnterWarehouse);

	/**
	 * 更新一条数据
	 * @param tbEnterWarehouse
	 * @return
	 */
	int updateEnterWarehouse(TbEnterWarehouse tbEnterWarehouse);
}
