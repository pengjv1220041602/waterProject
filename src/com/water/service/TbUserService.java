package com.water.service;

import java.util.List;

import com.water.pojo.TbUser;

public interface TbUserService {
	/**
	 * 删除用户信息
	 * @param tbUser
	 * @return
	 */
	boolean deleteTbUser(TbUser tbUser);
	/**
	 * 得到所有的用户信息
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
	 * 添加或修改根据用户id ， 如果有id那么是修改，如果没有id那么是添加
	 * @param tbUser
	 * @return
	 */
	boolean addOrUpdateTbUser(TbUser tbUser);
}
