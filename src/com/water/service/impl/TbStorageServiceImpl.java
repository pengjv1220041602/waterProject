package com.water.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.water.mapper.TbStorageMapper;
import com.water.pojo.TbStorage;
import com.water.service.TbStorageService;
import com.water.util.AddOrUpdateUtils;
import com.water.util.GetUUIDUtils;
import com.water.util.StringUtils;

@Service
public class TbStorageServiceImpl implements TbStorageService{
	
	@Autowired
	private TbStorageMapper tbStorageMapper;

	@Override
	public List<TbStorage> getAllTbStorage(TbStorage tbStorage) {
		return tbStorageMapper.getAllTbStorage(tbStorage);
	}

	@Override
	public TbStorage getTbStorage(TbStorage tbStorage) {
		return tbStorageMapper.getTbStorage(tbStorage);
	}

	@Override
	public boolean addOrUpdateTbStorage(TbStorage tbStorage) {
		int flag = 0;
		AddOrUpdateUtils.addOrUpdateUtils(tbStorage);
		if (null != tbStorage && !StringUtils.isBlank(tbStorage.getId())) {
			flag = tbStorageMapper.updateTbStorage(tbStorage);
		} else {
			tbStorage.setId(GetUUIDUtils.getUUID());
			flag = tbStorageMapper.addTbStorage(tbStorage);
		}
		return flag > 0 ? true : false;
	}
}
