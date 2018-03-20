package com.water.mapper;

import java.util.List;

import com.water.pojo.TbStorage;

public interface TbStorageMapper {

	/**
	 * 获取所有对应 仓库集合
	 * @param tbStorage
	 * @return
	 */
	List<TbStorage> getAllTbStorage(TbStorage tbStorage);
	
	/**
	 * 得到一个库存信息
	 * @param tbStorage
	 * @return
	 */
	TbStorage getTbStorage(TbStorage tbStorage);

	/**
	 * 添加一个库存信息
	 * @param tbStorageTemp
	 */
	int addTbStorage(TbStorage tbStorage);
	
	/**
	 * 修改一个库存信息
	 * @param tbStorage
	 * @return
	 */
	int updateTbStorage(TbStorage tbStorage);
}
