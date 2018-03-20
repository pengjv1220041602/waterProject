package com.water.service;

import java.util.List;

import com.water.pojo.TbStorage;

public interface TbStorageService {
	
	/**
	 * 获取所有对应的库存信息
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
	 * 更新或添加一个库存信息
	 * @param tbStorageTemp
	 * @return
	 */
	boolean addOrUpdateTbStorage(TbStorage tbStorage);

}
