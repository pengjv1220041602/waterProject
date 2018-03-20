package com.water.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/showIndexPage")
@Controller
public class ShowIndexPageController {
	
	@RequestMapping("/topShow")
	public String topShow() {
		return "top";
	}
	
	@RequestMapping("/leftShow")
	public String leftShow(){
		return "left";
	}
	
	@RequestMapping("/indexShow")
	public String indexShow() {
		return "index";
	}
}
