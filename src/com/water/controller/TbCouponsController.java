package com.water.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.water.authen.Authen;
import com.water.pojo.TbCoupons;
import com.water.service.TbCouponsService;
import com.water.util.StringUtils;

@Controller
@RequestMapping("/tbCoupons")
public class TbCouponsController {
	
	@Autowired
	private TbCouponsService tbCouponsService;
	
	@RequestMapping("/showAllTbCoupons")
	public String showAllTbCoupons(TbCoupons tbCoupon, Model model) {
		List<TbCoupons> tbCoupons = tbCouponsService.getAllTbCoupons(tbCoupon);
		model.addAttribute("tbCoupons", tbCoupons);
		return "showCoupons";
	}
	
	@RequestMapping("/addOrUpdateTbCouponsPage")
	public String addOrUpdateTbCouponsPage(TbCoupons tbCoupons, Model model) {
		if(null != tbCoupons && !StringUtils.isBlank(tbCoupons.getId())){
			tbCoupons = tbCouponsService.getTbCoupons(tbCoupons);
		}
		model.addAttribute("tbCoupons", tbCoupons);
		return "addOrUpdateTbCoupons";
	}
	@RequestMapping("/addOrUpdateTbCoupons")
	public String addOrUpdateTbCoupons(TbCoupons tbCoupons) {
		tbCouponsService.addOrUpdateTbCoupons(tbCoupons);
		return "redirect:"+"/tbCoupons/showAllTbCoupons.action";
	}
	
	@RequestMapping("/issueProductAndCoupons")
	public String issueProductAndCoupons (TbCoupons tbCoupons) {
		
		return null;
	}
	@RequestMapping("/deleteCoupons")
	public String deleteCoupons(TbCoupons tbCoupons) {
		boolean flag = tbCouponsService.deleteCoupons(tbCoupons);
		return null;
	}
	
	@RequestMapping("/showTbCouponByJson")
	@Authen()
	@ResponseBody
	public TbCoupons showTbCouponByJson(TbCoupons tbCoupon) {
		return tbCouponsService.getTbCoupons(tbCoupon); 
	}
}
