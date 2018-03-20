package com.water.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.water.constant.Constant;
import com.water.mapper.TbKindMapper;
import com.water.pojo.TbKind;
import com.water.service.TbKindService;
import com.water.util.AddOrUpdateUtils;
import com.water.util.GetUUIDUtils;
import com.water.util.StringUtils;

@Service
public class TbKindServiceImpl implements TbKindService{

	@Autowired
	private TbKindMapper tbkindmapper;
	
	@Override
	public boolean deleteTbKind(TbKind tbkind) {
		// TODO 逻辑删除
		tbkind.setFlag(Constant.DEL_FLAG);
		int flag = tbkindmapper.updateTbKind(tbkind);
		
		return flag > 0 ? true : false;
	}

	@Override
	public List<TbKind> getAllTbKind(TbKind tbkind) {
		// TODO Auto-generated method stub
		
		return tbkindmapper.getAllTbKind(tbkind);
	}

	@Override
	public TbKind getTbKind(TbKind tbkind) {
		// TODO Auto-generated method stub
		return tbkindmapper.getTbKind(tbkind);
	}

	@Override
	public boolean addOrUpdateTbKind(TbKind tbkind) {
		// TODO 处理添加或者是修改
		int flag = 0;
		AddOrUpdateUtils.addOrUpdateUtils(tbkind);
		if(!StringUtils.isBlank(tbkind.getId())){
			flag = tbkindmapper.updateTbKind(tbkind);
		}else{
			tbkind.setId(GetUUIDUtils.getUUID());
			flag = tbkindmapper.insertTbKind(tbkind);
		}
		if(flag > 0){
			return true;
		}
		return false;
	}

}
