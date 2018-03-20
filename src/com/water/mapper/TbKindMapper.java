package com.water.mapper;

import java.util.List;

import com.water.pojo.TbKind;


public interface TbKindMapper {
	/**
	 * 得到相应的商品集合
	 * @param tbkind
	 * @return
	 */
	List<TbKind> getAllTbKind(TbKind tbkind);
	
	/**
	 * 得到相应的商品对象
	 * @param tbkind
	 * @return
	 */
	TbKind getTbKind(TbKind tbkind);
	
	/**
	 * 添加商品
	 * @param tbkind
	 * @return
	 */
	int updateTbKind(TbKind tbkind);
	
	/**
	 * 修改商品
	 * @param tbkind
	 * @return
	 */
	int insertTbKind(TbKind tbkind);
}
