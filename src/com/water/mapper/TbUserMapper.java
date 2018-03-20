package com.water.mapper;

import java.util.List;

import com.water.pojo.TbUser;

public interface TbUserMapper {

	/**
	 * 得到相应的用户集合
	 * @param tbUser
	 * @return
	 */
	List<TbUser> getAllTbUsers(TbUser tbUser);
	
	/**
	 * 得到相应的用户对象
	 * @param tbUser
	 * @return
	 */
	TbUser getTbUser(TbUser tbUser);

	/**
	 * 添加用户
	 * @param tbUser
	 * @return
	 */
	int updateTbUser(TbUser tbUser);
	
	/**
	 * 修改用户
	 * @param tbUser
	 * @return
	 */
	int insertTbUser(TbUser tbUser);
}