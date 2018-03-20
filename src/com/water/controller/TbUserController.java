package com.water.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.water.authen.Authen;
import com.water.pojo.TbUser;
import com.water.service.TbUserService;
import com.water.util.StringUtils;

@Controller
@RequestMapping("/tbUser")
public class TbUserController {
	
	@Autowired
	private TbUserService tbUserService;
	
	@RequestMapping(value="/login")
	public String login (TbUser tbUser, Model model, HttpServletRequest request) {
		TbUser user = tbUserService.getTbUser(tbUser);
		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			return "redirect:"+"/tbUser/adminMain.action";
		}
		return "login";
	}
	@Authen()
	@RequestMapping("/adminMain")
	public String adminMain(TbUser tbUser) {
		return "adminMain";
	}
	
	@RequestMapping("/getAllTbUsers")
	public String getAllTbUsers(TbUser tbUser,Model model) {
		model.addAttribute("tbUsers", tbUserService.getAllTbUsers(tbUser));
		return "showUsers";
	}
	@Authen()
	@RequestMapping("/addOrUpdateTbUserPage")
	public String addOrUpdateTbUserPage(TbUser tbUser, Model model) {
		if (null != tbUser && !StringUtils.isBlank(tbUser.getId())) {
			tbUser = tbUserService.getTbUser(tbUser);
		}
		model.addAttribute("tbUser", tbUser);
		return "addOrUpdateUser";
	}
	@Authen()
	@RequestMapping(value="addOrUpdateTbUser",method=RequestMethod.POST)
	public String addOrUpdateTbUser(TbUser tbUser) {
		//TODO 后台验证
		boolean flag = tbUserService.addOrUpdateTbUser(tbUser);
		if (flag) {
			return "redirect:"+"/tbUser/getAllTbUsers.action";
		}
		return "addOrUpdateUser";
	}
	@Authen()
	@RequestMapping("deleteTbUser")
	public String deleteTbUser(TbUser tbUser) {
			tbUserService.deleteTbUser(tbUser);
			return "redirect:"+"/tbUser/getAllTbUsers.action";
	}
	@Authen()
	@RequestMapping("/getAllTbUsersByJosn")
	@ResponseBody
	public List<TbUser> getAllTbUsersByJson(TbUser tbUser) {
		return tbUserService.getAllTbUsers(tbUser);
	}
}
