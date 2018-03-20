package com.water.service;

import java.util.List;

import com.water.pojo.TbKind;

public interface TbKindService {
	
	/**
	 * 删除商品类别
	 * @param tbkind
	 * @return
	 */
	boolean deleteTbKind(TbKind tbkind);
	
	/**
	 *得到所有商品信息
	 * @param tbkind
	 * @return
	 */
	List<TbKind> getAllTbKind(TbKind tbkind);
	
	/**
	 * 得到对应的商品对象
	 * @param tbkind
	 * @return
	 */
	TbKind getTbKind(TbKind tbkind);
	
	/**
	 * 添加或者修改商品，根据id，如果有id为修改，没有id为添加
	 * @param tbkind
	 * @return
	 */
	boolean addOrUpdateTbKind(TbKind tbkind);
}
