package com.water.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.water.mapper.TbEnterWarehouseMapper;
import com.water.pojo.TbEnterWarehouse;
import com.water.pojo.TbStorage;
import com.water.service.TbEnterWarehouseService;
import com.water.service.TbStorageService;
import com.water.util.AddOrUpdateUtils;
import com.water.util.GetUUIDUtils;
import com.water.util.StringUtils;

@Service
public class TbEnterWarehouseServiceImpl implements TbEnterWarehouseService{

	@Autowired
	private TbEnterWarehouseMapper tbEnterWarehouseMapper;
	@Autowired
	private TbStorageService tbStorageService;
	
	@Override
	public List<TbEnterWarehouse> getAllTbEnterWarehouse(TbEnterWarehouse enterWarehouse) {
		return tbEnterWarehouseMapper.getAllTbEnterWarehouse(enterWarehouse);
	}

	@Override
	public TbEnterWarehouse getTbEnterWarehouse(TbEnterWarehouse enterWarehouse) {
		return tbEnterWarehouseMapper.getTbEnterWarehouse(enterWarehouse);
	}

	@Override
	public boolean addOrUpdateEnterWarehouse(TbEnterWarehouse tbEnterWarehouse) {
		int flag = 0;
		AddOrUpdateUtils.addOrUpdateUtils(tbEnterWarehouse);
		if (!StringUtils.isBlank(tbEnterWarehouse.getId())) {
			flag = tbEnterWarehouseMapper.updateEnterWarehouse(tbEnterWarehouse);
		} else {
			tbEnterWarehouse.setId(GetUUIDUtils.getUUID());
			flag = tbEnterWarehouseMapper.insertEnterWarehouse(tbEnterWarehouse);
			
			TbStorage tbStorage = new TbStorage();
			tbStorage.setTbProduct(tbEnterWarehouse.getTbProduct());
			tbStorage = tbStorageService.getTbStorage(tbStorage);
			//库存中含有或者没有
			int resultNum = tbStorage == null ? tbEnterWarehouse.getEnterWarehouseNum() : 
				tbStorage.getStorageNum() + tbEnterWarehouse.getEnterWarehouseNum();
				//如果是null
			if (tbStorage == null) {
				tbStorage = new TbStorage();	
			}
			tbStorage.setStorageNum(resultNum);
			tbStorage.setTbProduct(tbEnterWarehouse.getTbProduct());
			tbStorageService.addOrUpdateTbStorage(tbStorage);
		}
		if (flag > 0){
			return true;
		}
		return false;
	}

}
