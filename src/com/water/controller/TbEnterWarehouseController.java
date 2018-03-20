package com.water.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.water.pojo.TbEnterWarehouse;
import com.water.pojo.TbKind;
import com.water.service.TbEnterWarehouseService;
import com.water.service.TbKindService;
import com.water.util.StringUtils;
import com.water.util.ValidateUtils;

@Controller
@RequestMapping("/tbEnterWarehouse")
public class TbEnterWarehouseController {
	
	@Autowired
	private TbEnterWarehouseService tbEnterWarehouseService;
	@Autowired
	private TbKindService tbKindService;
	
	@RequestMapping("/getAllTbEnterWarehouse")
	public String getAllTbEnterWarehouse(TbEnterWarehouse enterWarehouse, Model model) {
		List<TbEnterWarehouse> enterWarehouses = tbEnterWarehouseService.getAllTbEnterWarehouse(enterWarehouse);
		model.addAttribute("enterWarehouses", enterWarehouses);
		return "showEnterWarehouses";
	}
	
	@RequestMapping("/addOrUpdateTbEnterWarehousePage")
	public String addOrUpdateTbEnterWarehousePage(TbEnterWarehouse enterWarehouse, Model model) {
		if(null != enterWarehouse && !StringUtils.isBlank(enterWarehouse.getId())){
			enterWarehouse = tbEnterWarehouseService.getTbEnterWarehouse(enterWarehouse);
		}
//		List<TbProduct> allTbProducts = tbProductService.getAllTbProducts(new TbProduct());
		List<TbKind> tbKinds = tbKindService.getAllTbKind(new TbKind());
		
		model.addAttribute("tbKinds", tbKinds);
		model.addAttribute("enterWarehouse", enterWarehouse);
		return "addOrUpdateTbEnterWarehouse";
	}
	
	@RequestMapping("/addOrUpdateEnterWarehouse")
	public String addOrUpdateEnterWarehouse(TbEnterWarehouse tbEnterWarehouse) {
		if (!ValidateUtils.validateBean(tbEnterWarehouse)) {
//			attr.addFlashAttribute("enterWarehouse", tbEnterWarehouse);
			return "redirect:"+"/tbEnterWarehouse/addOrUpdateTbEnterWarehousePage.action";
		}
		tbEnterWarehouseService.addOrUpdateEnterWarehouse(tbEnterWarehouse);
		return "redirect:"+"/tbEnterWarehouse/getAllTbEnterWarehouse.action";
	}
}
