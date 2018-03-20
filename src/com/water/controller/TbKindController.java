package com.water.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.water.authen.Authen;
import com.water.pojo.TbKind;
import com.water.service.TbKindService;
import com.water.util.StringUtils;
import com.water.util.ValidateUtils;

@Controller
@RequestMapping("/tbkind")
public class TbKindController {
	
	@Autowired
	private TbKindService tbkindservice;
	
	@Authen()
	@RequestMapping("/getAllTbKind")
	public String getAllTbKind(TbKind tbkind,Model model){
		System.out.println(tbkindservice.getAllTbKind(tbkind).toString()+"ceshi");
		model.addAttribute("tbkind", tbkindservice.getAllTbKind(tbkind));
		return "showkind";
	}
	
	@Authen()
	@RequestMapping("/addOrUpdateTbKindPage")
	public String updateTbKind(TbKind tbkind, Model model){
		if(null != tbkind && !StringUtils.isBlank(tbkind.getId())){
			tbkind = tbkindservice.getTbKind(tbkind);
		}
		model.addAttribute("tbkind", tbkind);
		return "addOrUpdatekind";
	}
	
	@Authen()
	@RequestMapping(value="addOrUpdatekind",method=RequestMethod.POST)
	public String addOrUpdatekind(TbKind tbkind, Model model){
		if (!ValidateUtils.validateBean(tbkind)) {
			model.addAttribute("tbkind", tbkind);
			return "addOrUpdatekind";
		}
		boolean flag = tbkindservice.addOrUpdateTbKind(tbkind);
		if(flag) {
			return "redirect:"+"/tbkind/getAllTbKind.action";
		}
		return "addOrUpdatekind";
	}
	
	@Authen()
	@RequestMapping("deleteTbKind")
	public String deleteTbKind(TbKind tbkind){
		tbkindservice.deleteTbKind(tbkind);
		return "redirect:"+"/tbkind/getAllTbKind.action";
	}
}
