package com.water.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.water.pojo.SysNode;
import com.water.service.SysNodeService;

@Controller
@RequestMapping("/sysNode")
public class SysNodeController {
	
	@Autowired
	private SysNodeService sysNodeService;
	
	@RequestMapping("/getSysNodes")
	@ResponseBody
	public List<SysNode> getFirstNodes(SysNode sysNode) {
		List<SysNode> sysNodes = sysNodeService.qryNodesToCondition(sysNode);
		return sysNodes;
	}
	
	@RequestMapping("/getAllSysNodes")
	public String getAllSysNodes(Model model){
		List<List<SysNode>> allSysNodes = sysNodeService.getAllSysNodes();
		model.addAttribute("allSysNodes", allSysNodes);
		model.addAttribute("aa", "aa");
		return "adminhomepage";
	}
	
	
	
}
