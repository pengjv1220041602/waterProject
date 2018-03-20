package com.water.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.water.pojo.TbProductTbCouponsVO;
import com.water.service.TbProductTbCouponsVOService;

@Controller
@RequestMapping("/tbProductTbCouponsVO")
public class TbProductTbCouponsVOController {
	
	@Autowired
	private TbProductTbCouponsVOService tbProductTbCouponsVOService;
	@RequestMapping("/getProductAndCoupons")
	@ResponseBody
	public List<TbProductTbCouponsVO> getProductAndCoupons(TbProductTbCouponsVO tbProductTbCouponsVO) {
		List<TbProductTbCouponsVO> VOs = tbProductTbCouponsVOService.getProductAndCoupons(tbProductTbCouponsVO);
		return VOs;
	}
	
	@RequestMapping("/addOrUpdateProductAndCoupons")
	@ResponseBody
	public void addOrUpdateProductAndCoupons(TbProductTbCouponsVO tbProductTbCouponsVO, @RequestParam(value="proIds",required=false) String[] proIds) {
		tbProductTbCouponsVOService.addOrUpdateProductAndCoupons(tbProductTbCouponsVO, proIds);
	}
	
}
