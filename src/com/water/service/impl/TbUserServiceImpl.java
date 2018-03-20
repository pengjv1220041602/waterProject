package com.water.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.water.constant.Constant;
import com.water.mapper.TbUserMapper;
import com.water.pojo.TbUser;
import com.water.service.TbUserService;
import com.water.util.AddOrUpdateUtils;
import com.water.util.GetUUIDUtils;
import com.water.util.StringUtils;

@Service
public class TbUserServiceImpl implements TbUserService{

	@Autowired
	private TbUserMapper tbUserMapper; 
	
	public boolean deleteTbUser(TbUser tbUser) {
		tbUser.setFlag(Constant.DEL_FLAG);
		int flag = tbUserMapper.updateTbUser(tbUser);
		return flag > 0 ? true : false;
	}

	public List<TbUser> getAllTbUsers(TbUser tbUser) {
		return tbUserMapper.getAllTbUsers(tbUser);
	}

	public TbUser getTbUser(TbUser tbUser) {
		return tbUserMapper.getTbUser(tbUser);
	}

	public boolean addOrUpdateTbUser(TbUser tbUser) {
		int flag = 0;
		AddOrUpdateUtils.addOrUpdateUtils(tbUser);
		tbUser.setUserAdmin(tbUser.getUserAdmin() == null ? Constant.USER_AUTH :tbUser.getUserAdmin());
		if (!StringUtils.isBlank(tbUser.getId())) {
			flag = tbUserMapper.updateTbUser(tbUser);
		} else {
			tbUser.setId(GetUUIDUtils.getUUID());
			flag = tbUserMapper.insertTbUser(tbUser);
		}
		if (flag > 0){
			return true;
		}
		return false;
	}

}
