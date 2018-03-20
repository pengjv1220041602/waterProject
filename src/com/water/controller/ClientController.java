package com.water.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.water.constant.Constant;
import com.water.pojo.TbCoupons;
import com.water.pojo.TbCouponsUserVO;
import com.water.pojo.TbProduct;
import com.water.pojo.TbProductTbCouponsVO;
import com.water.pojo.TbUser;
import com.water.service.ClientService;
import com.water.service.TbCouponsService;
import com.water.service.TbCouponsUserService;
import com.water.service.TbProductService;
import com.water.service.TbProductTbCouponsVOService;
import com.water.service.TbUserService;
import com.water.util.StringUtils;

@Controller
public class ClientController {
	@Autowired
	private TbProductService tbProductService;
	@Autowired
	private TbProductTbCouponsVOService tbProductTbCouponsVOService;
	@Autowired
	private TbCouponsService tbCouponsService;
	@Autowired
	private TbUserService tbUserService;
	@Autowired
	private ClientService clientService;
	
	@RequestMapping(value={"/home","/"})
	public String homeRedirect (Model model) {
		List<TbProduct> tbProducts = tbProductService.getAllTbProducts(new TbProduct());
		model.addAttribute("tbProducts", tbProducts);
		return "home";
	}
	
	@RequestMapping(value="/clientProducts")
	public String clientProducts (Model model) {
		List<TbProduct> tbProducts = tbProductService.getAllTbProducts(new TbProduct());
		model.addAttribute("tbProducts", tbProducts);
		return "clientProduct";
	}
	@RequestMapping(value="/showProductInfo")
	public String showProductInfo(TbProduct tbProduct, Model model) {
		tbProduct = tbProductService.getTbProduct(tbProduct);
		model.addAttribute("tbProduct", tbProduct);
		return "";
	}
	@RequestMapping(value="/showTbCouPonsProduct")
	public String showTbCouPonsProduct(Model model) {
		List<TbProductTbCouponsVO> productAndCoupons = tbProductTbCouponsVOService.getAllProductAndCoupons(new TbProductTbCouponsVO());
		
		TbCoupons tbCoupon = new TbCoupons();
		tbCoupon.setCouponsTimeOwn(Constant.TbCouponsConstant.QIANG_GOU);
		tbCoupon.setCouponsBeginTime(new Date());
		
		List<TbCoupons> tbCoupons = tbCouponsService.getAllTbCoupons(tbCoupon);
		model.addAttribute("productAndCoupons", productAndCoupons);
		model.addAttribute("tbCoupons", tbCoupons);
		return "clientCoupons";
	}
	@RequestMapping(value="/tbUserLogin",method=RequestMethod.POST)
	public String tbUserLogin(TbUser tbUser, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (StringUtils.isBlank(tbUser.getLoginName()) || StringUtils.isBlank(tbUser.getPassword())) {
			return "redirect:"+"/home.action";
		}
		TbUser user = tbUserService.getTbUser(tbUser);
		if (user != null) {
			session.setAttribute("user", user);
		}
		return "redirect:"+"/home.action";
	}
	@ResponseBody
	@RequestMapping("/getCoupons")
	public Map<String, String> getCoupons(TbCouponsUserVO tbCouponsUserVO){
		Map<String, String> result = clientService.getCoupons(tbCouponsUserVO);
		return result;
	} 
	@RequestMapping("/redirectCompanyInfo")
	public String redirectCompanyInfo () {
		return "clientCompanyInfo";
	}
	@RequestMapping("/redirectCompanyTel")
	public String redirectCompanyTel () {
		return "clientTel";
	}
}
