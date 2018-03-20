package com.water.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.water.pojo.TbStorage;
import com.water.service.TbStorageService;

@Controller
@RequestMapping("/tbStorage")
public class TbStorageController {
	
	@Autowired
	private TbStorageService tbStorageService;
	
	@RequestMapping("/getAllTbStorage")
	public String getAllTbKind(TbStorage tbStorage,Model model){
		model.addAttribute("tbStorages", tbStorageService.getAllTbStorage(tbStorage));
		return "showStorage";
	}
}
