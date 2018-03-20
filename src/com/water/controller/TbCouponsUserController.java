package com.water.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.water.service.TbCouponsUserService;

@Controller
@RequestMapping("/tbCouponsUser")
public class TbCouponsUserController {
	@Autowired
	private TbCouponsUserService tbCouponsUserService;
	
	@RequestMapping(value="/addOrUpdateTbCouponsUsers",method=RequestMethod.POST)
	@ResponseBody
	public void addTbCouponsUsers(@RequestParam(value="userIds",required=false) String[] userIds, 
								  @RequestParam(value="couponsNums",required=false)Integer[] couponsNums, 
								  @RequestParam(value="couponsId",required=true)String couponsId) {
		tbCouponsUserService.addTbCouponsUsers(userIds,couponsNums,couponsId);
	}
}
